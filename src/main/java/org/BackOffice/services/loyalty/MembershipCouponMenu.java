package org.BackOffice.services.loyalty;

import org.BackOffice.services.loyalty.domain.MenuItem;
import org.BackOffice.services.loyalty.domain.Order;
import org.BackOffice.services.loyalty.domain.OrderItem;
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
        OrderService orderService = new OrderService();

        boolean choosing = true;

        Scanner sc = new Scanner(System.in);

        while (choosing) {
            System.out.println("1.메뉴 선택\n2.결제하기\n3.나가기");
            int actInput = sc.nextInt();

            switch (actInput) {
                case 1 -> {
                    showMenuBoard();
                    int menuId = readMenuSelection();
                    int quantity = readQuantity();

                }
                case 2 ->  {
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
}
