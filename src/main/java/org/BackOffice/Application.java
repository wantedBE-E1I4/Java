package org.BackOffice;

import org.BackOffice.services.orderstatus.domain.Order;
import org.BackOffice.services.orderstatus.parser.OrderParser;
import org.BackOffice.services.orderstatus.service.OrderStatusService;

import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        // 1단계: 파싱할 원본 텍스트 데이터 준비
        String ORDERS_DATA = "# orderId|datetime|branch|userId|items|couponCode|status\n" +
                "001|2025-09-22T09:05|강남|U1001|아메리카노x2;라떼x1||COMPLETED\n" +
                "002|2025-09-22T09:17|강남|U1002|바닐라라떼x1||CANCELLED\n" +
                "003|2025-09-22T10:02|홍대|U1003|아메리카노x1;카푸치노x1||COMPLETED\n" +
                "004|2025-09-22T10:35|강남|U1004|라떼x2;바닐라라떼x1|WELCOME5|COMPLETED\n" +
                "005|2025-09-22T11:10|홍대|U1005|콜드브루x2||COMPLETED\n" +
                "006|2025-09-22T12:45|강남|U1006|아메리카노x3||COMPLETED\n" +
                "007|2025-09-22T13:20|강남|U1007|라떼x1;콜드브루x1||REFUNDED";

        // 2단계: Parser를 사용해 텍스트 데이터를 Order 객체 리스트로 변환
        //System.out.println("데이터 파싱을 시작합니다...");
        List<Order> parsedOrders = OrderParser.parseOrders(ORDERS_DATA);
       // System.out.println("데이터 파싱 완료!");

        // 3단계: 파싱된 데이터를 Service에 전달하여 서비스 객체 생성
        OrderStatusService orderStatusService = new OrderStatusService(parsedOrders);

        // 4단계: Service의 기능을 실행하여 주문 현황 출력
        orderStatusService.printAllOrders();

        // 참고: 다른 팀의 기능은 기존 InMemoryData를 그대로 사용할 수 있습니다.
        // System.out.println("\n--- 기존 재고 데이터 (영향 없음) ---");
        // System.out.println(org.BackOffice.domain.InMemoryData.INVENTORY);


        // 대시보드
        System.out.println(
                "1.재고 관리\n2.매출 분석\n3.주문 현황 관리\n4.멤버십/쿠폰 관리\n5.메뉴 관리");
        Scanner sc = new Scanner(System.in);

        System.out.println("어떤 업무를 보시겠어요?");
        int input = sc.nextInt();

        switch (input) {
            case 1 -> {
                InventoryMenu inventoryMenu = new InventoryMenu;
            }
            case 2 -> {
                SalesMenu inventoryMenu = new SalesMenu;
            }
            case 3 -> {
                OrderMonitorMenu inventoryMenu = new OrderMonitorMenu;
            }
            case 4 -> {
                MembershipCouponMenu inventoryMenu = new MembershipCouponMenu;
            }
            case 5 -> {
                ProductMenu inventoryMenu = new ProductMenu;
            }
        }
    }
}