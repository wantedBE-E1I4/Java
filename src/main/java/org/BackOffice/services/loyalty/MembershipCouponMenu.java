package org.BackOffice.services.loyalty;

import org.BackOffice.services.loyalty.domain.Guest;
import org.BackOffice.services.loyalty.domain.LoyaltyAccount;
import org.BackOffice.services.loyalty.domain.MenuItem;
import org.BackOffice.services.loyalty.domain.Order;
import org.BackOffice.services.loyalty.repository.GuestRepository;
import org.BackOffice.services.loyalty.repository.LoyaltyRepository;
import org.BackOffice.services.loyalty.repository.OrderRepository;
import org.BackOffice.services.loyalty.service.GuestService;
import org.BackOffice.services.loyalty.service.LoyaltyService;
import org.BackOffice.services.loyalty.service.OrderService;

import java.util.Scanner;

public class MembershipCouponMenu {
    private final static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        MembershipCouponMenu membership = new MembershipCouponMenu();
        membership.enter();
    }

    /**
     * 손님 입장
     */
    private void enter() {
        boolean inCafe = true;
        while (inCafe) {
            // 1) 주문의사 확정
            int actInput = confirmOrderIntent();

            switch (actInput) {
                case 1 -> {
                    startOrder();
                }
                case 2 -> {
                    System.out.println("안녕히 가세요!");
                    inCafe = false;// ← UI 세션 종료: 도메인 상태 변경 없음
                }
            }
        }
    }

    /**
     * 주문 시작
     */
    public void startOrder() {
        GuestRepository guestRepository = new GuestRepository();
        OrderRepository orderRepository = new OrderRepository();
        LoyaltyRepository loyaltyRepository = new LoyaltyRepository();

        GuestService guestService = new GuestService();
        OrderService orderService = new OrderService();
        LoyaltyService loyaltyService = new LoyaltyService();

        int guestId = guestService.createGuest(guestRepository);

        //손님 id 선택
        System.out.println("["+guestId + "번 손님]");



        boolean choosing = true;
        while (choosing) {
            int actInput = promptMainAction(); // 메뉴 선택, 결제하기, 나가기

            switch (actInput) {
                case 1 -> {
                    showMenuBoard();
                    int menuId = readMenuSelection();
                    int quantity = readQuantity();
                    int orderId = orderService.startOrderForGuest(guestRepository, orderRepository, guestId);
                    Order order = orderService.findOrder(orderRepository, orderId);
                    order.addItem(menuId, quantity);
                    orderService.saveOrder(orderRepository, order);
                }
                case 2 ->  {
                    //적립금 생성

                    // 결제하기
                    Guest guest = guestService.findGuest(guestRepository, guestId);
                    int openOrderId = guest.getOpenOrderId();
                    Order order = orderService.findOrder(orderRepository, openOrderId);

                    loyaltyService.accruePoints(loyaltyRepository, guestId, order.getTotalPay());

                    orderService.switchToPaid(orderRepository, openOrderId);
                    int cups = order.getTotalCups();

                    // 프로모션
                    validateBeforePay(cups);

                    //적립금
                    orderService.accrueLoyaltyPointsForPaidOrder(orderRepository, openOrderId);
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
     * @return
     */
    public int promptMainAction() {
        System.out.println("1.메뉴 선택\n2.결제하기\n3.나가기");
        return sc.nextInt();
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
     * 메뉴판 UI 번호 입력
     * @return
     */
    public int readMenuSelection() {
        return menuDisplayIndexToId(sc.nextInt());
    }

    /**
     * 메뉴판 번호를 menuItem의 Id로 변환
     * @param menuDisplayNo
     * @return int
     */
    public int menuDisplayIndexToId(int menuDisplayNo) {
        int id = 0;
        switch (menuDisplayNo) {
            case 1 -> {
                id = MenuItem.AMERICANO.id;
            }
            case 2 -> {
                id = MenuItem.LATTE.id;
            }
            case 3 -> {
                id = MenuItem.MOCHA.id;
            }
        }
        return id;
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
}
