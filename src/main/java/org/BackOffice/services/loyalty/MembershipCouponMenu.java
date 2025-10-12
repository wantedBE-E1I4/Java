package org.BackOffice.services.loyalty;

import org.BackOffice.domain.InMemoryData;
import org.BackOffice.services.loyalty.adapter.MenuAdapter;
import org.BackOffice.services.loyalty.domain.*;
import org.BackOffice.services.loyalty.service.*;

import java.util.List;
import java.util.Scanner;

/**
 * 파트 독립 실행 구조로 구성 (임시 컨텍스트 사용)
 * - 메뉴 진입 시 AppContext/Service 로컬 초기화
 * - 타 메뉴와 데이터 비공유
 * - 추후 대시보드 기반 공용 컨텍스트/생성자 주입으로 통합 예정
 */
public class MembershipCouponMenu {
    private final static Scanner sc = new Scanner(System.in);

    private final AppContext appCtx = new AppContext();
    private final ServiceFactory factory = new ServiceFactory();

    private final GuestService guestService = factory.createGuestService(appCtx.getGuestRepo());
    private final OrderService orderService = factory.createOrderService(appCtx.getOrderRepo());
    private final LoyaltyService loyaltyService = factory.createLoyaltyService(appCtx.getLoyaltyRepo());

    public static void main(String[] args) {
        MembershipCouponMenu membership = new MembershipCouponMenu();
        membership.enter();
    }

    /**
     * 손님 입장
     * <br>- 주문의사 확정 or 종료
     */
    private void enter() {
        boolean inCafe = true;
        while (inCafe) {
            int actInput = confirmOrderIntent();

            switch (actInput) {
                case 1 -> {
                    Long guestId = selectOrCreateGuest();
                    switch (chooseInputMethod()) {
                        case MANUAL -> startOrder(guestId);
                        case VOICE -> startCallOrder(guestId);
                    }
                }
                case 2 -> {
                    System.out.println("안녕히 가세요!");
                    inCafe = false;// ← UI 세션 종료: 도메인 상태 변경 없음
                }
            }
        }
    }

    /**
     * 게스트 식별 확정
     * <br>- 게스트 목록 (기존 선택 or 신규 생성)
     * @Return 유효한 guestId
     * @Return 잘못입력 시 -1 반환(임시)
     */
    public Long selectOrCreateGuest() {
        System.out.println("1.기존 선택 2.신규 생성");
        int inputNum = sc.nextInt();
        switch (inputNum) {
            case 1 -> {
                //return guestService.selectExistingGuest();
            }
            case 2 -> {
                return guestService.createGuest();
            }
        }
        //TODO 잘못 입력에 대한 방어 코드 필요
        return -1L;
    }

    /**
     * 입력 방식 선택
     * @return MANUAL, VOICE
     */
    public Method chooseInputMethod() {
        System.out.println("1.직접입력 2.구두입력");
        int inputNum = sc.nextInt();
        if (inputNum == 1) {
            return Method.MANUAL;
        } else {
            return Method.VOICE;
        }
    }

    /**
     * 주문 시작(MANUAL)
     */
    public void startOrder(Long guestId) {
        boolean choosing = true;
        while (choosing) {
            int actInput = promptMainAction();

            switch (actInput) {
                case 1 -> {
                    showMenuBoard();
                    int menuId = readMenuSelection();
                    int quantity = readQuantity();
                    Long orderId = orderService.createOrder(guestId);

                    guestService.assignOpenOrderToGuest(guestId, orderId);
                    Order order = orderService.findOrder(orderId);
                    order.addItem(menuId, quantity);
                    orderService.saveOrder(order);
                }
                case 2 ->  {
                    proceedToCheckout(guestId);

                }
                case 3 -> {
                    System.out.println("선택 종료");
                    choosing = false;
                }
            }
        }
    }

    /**
     * 메인 행위 입력
     * <br>-1.메뉴 선택 2.결제하기 3.나가기
     * @return
     */
    public int promptMainAction() {
        System.out.println("1.메뉴 선택\n2.결제하기\n3.나가기");
        return sc.nextInt();
    }

    /**
     * 주문 시작(VOICE)
     */
    public void startCallOrder(Long guestId){
        MenuAdapter adapter = new MenuAdapter();

        for (InMemoryData.Order value : InMemoryData.ORDERS) {
            Long orderId = orderService.createOrder(value.id());
            Order order = orderService.findOrder(orderId);

            for (InMemoryData.OrderLine line : value.lines()) {
                int menuId = adapter.resolveMenuItem(line.menu());
                order.addItem(menuId, line.qty());
            }
            orderService.saveOrder(order);
        }

        proceedToCheckout(guestId);
    }

    public void proceedToCheckout(Long guestId) {
        Guest guest = guestService.findGuest(guestId);
        Long openOrderId = guest.getOpenOrderId();
        Order order = orderService.findOrder(openOrderId);

        // 적립금 생성 및 저장
        loyaltyService.accruePoints(guestId, order.getTotalPay());

        // 적립금 반영
        if (usePoints()) {
            // 적립금 조회
            int pointsBalance = loyaltyService.getPointsBalance(guestId);
            System.out.println("적립금: " + pointsBalance);
            int appliedPoints = orderService.applyPointsUse(pointsBalance, openOrderId);
            loyaltyService.redeemPoints(guestId, appliedPoints);
        }

        // 결제 완료
        orderService.switchToPaid(openOrderId);

        int cups = order.getTotalCups();

        // 프로모션
        validateBeforePay(cups);

        //영수증 출력
        //checkoutReceipt();

        //멤버십 관리
        printMembershipSummary(guestId);
    }

    /**
     * 메뉴 항목 노출
     */
    public void showMenuBoard() {
        System.out.print("☕️ MenuItem|Price\n");
        MenuItem[] menus = MenuItem.values();
        for (int i = 0; i < menus.length; i++) {
            System.out.println((i+1) + "." + menus[i].menuFormatter());
        }
    }

    /**
     * 메뉴판 UI 번호
     * <br>- 고유 Id 매핑
     * @return menuId
     * <br>- 매칭 실패 시 -1 반환
     */
    public int readMenuSelection() {
        int idx = sc.nextInt();
        return MenuItem.findByDisplayIndex(idx);
    }

    /**
     * 수량 입력
     * @return
     */
    public int readQuantity() {
        System.out.println("수량을 입력하세요");
        return sc.nextInt();
    }

    /**
     * 주문 수량 검증
     */
    public void validateBeforePay(int cups) {
        if (cups >= 5) {
            System.out.println("💰 결제 완료! 이번 주문 5잔 달성으로 무료 음료 쿠폰 1장 발급.");
        } else {
            System.out.println("💰 결제 완료!");
        }
    }

    /**
     * 주문의사 확정
     */
    public int confirmOrderIntent() {
        System.out.println("================");
        System.out.println("1.주문하기\n2.나가기");
        System.out.println("================");
        return sc.nextInt();
    }

    /**
     * 적립금 사용 여부
     * @return
     */
    public boolean usePoints() {
        System.out.println("적립금을 사용하시겠어요? 1.네 2.아니오");
        switch (sc.nextInt()) {
            case 1 -> {
                return true;
            }
            case 2 -> {
                return false;
            }
        }
        return false;
    }



    /**
     * 멤버십 요약 출력
     * @param guestId
     */
    public void printMembershipSummary(Long guestId) {
        System.out.println("[멤버십 관리]");
        System.out.println("고객ID: U" + guestId);
        System.out.println("적립 포인트: +" + loyaltyService.getPointsBalance(guestId));
    }
}
