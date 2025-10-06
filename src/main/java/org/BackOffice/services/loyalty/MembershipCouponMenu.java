package org.BackOffice.services.loyalty;

import org.BackOffice.services.loyalty.domain.Guest;
import org.BackOffice.services.loyalty.domain.MenuItem;
import org.BackOffice.services.loyalty.domain.Order;
import org.BackOffice.services.loyalty.service.GuestService;
import org.BackOffice.services.loyalty.service.OrderService;

import java.util.Scanner;

public class MembershipCouponMenu {
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
            System.out.println("================");
            System.out.println("1.주문하기\n2.나가기");
            System.out.println("================");
            Scanner sc = new Scanner(System.in);
            int actInput = sc.nextInt();

            switch (actInput) {
                case 1 -> {
                    startOrder();
                }
                case 2 -> {
                    System.out.println("안녕히 가세요!");
                    inCafe = false;
                }
            }
        }
    }

    /**
     * 주문 시작
     */
    public void startOrder() {

        GuestService guestService = new GuestService();

        int currentGuestId = guestService.createGuest();

        boolean choosing = true;
        while (choosing) {
            int actInput = promptMainAction();

            switch (actInput) {
                case 1 -> {
                    showMenuBoard();
                    int menuId = readMenuSelection();
                    int quantity = readQuantity();
                    Order order = startOrderForGuest(currentGuestId);
                    order.addItem(menuId, quantity);
                }
                case 2 ->  {
                    // 결제하기
                    // 멤버십, 적립금, 포인트, 행사(5잔 구매시 1잔 무료)
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
        Scanner sc = new Scanner(System.in);
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
        Scanner sc = new Scanner(System.in);
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
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    /**
     * 게스트 생성 + 주문 생성
     */
    public Order startOrderForGuest(int guestId) {
        OrderService orderService = new OrderService();

        return orderService.createOrder(guestId);
    }


}
