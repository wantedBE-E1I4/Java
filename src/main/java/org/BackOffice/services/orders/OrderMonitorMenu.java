package org.BackOffice.services.orders;

import org.BackOffice.services.orderstatus.domain.Order;
import org.BackOffice.services.orderstatus.parser.OrderParser;
import org.BackOffice.services.orderstatus.service.OrderStatusService;
import java.util.List;
import java.util.Scanner;

public class OrderMonitorMenu {

    private OrderStatusService orderStatusService;
    private final Scanner scanner = new Scanner(System.in);

    public OrderMonitorMenu() {
        initializeService();
    }

    private void initializeService() {
        // [수정 1] 테스트를 위해 'PLACED' 상태의 샘플 데이터를 추가합니다.
                
        String ORDERS_DATA =
                "# orderId|datetime|branch|userId|items|couponCode|status\n" +
                "001|2025-09-22T09:05|강남|U1001|아메리카노x2;라떼x1||COMPLETED\n" +
                "002|2025-09-22T09:17|강남|U1002|바닐라라떼x1||CANCELLED\n" +
                "003|2025-09-22T10:02|홍대|U1003|아메리카노x1;카푸치노x1||COMPLETED\n" +
                "004|2025-09-22T10:35|강남|U1004|라떼x2;바닐라라떼x1|WELCOME5|COMPLETED\n" +
                "005|2025-09-22T11:10|홍대|U1005|콜드브루x2||COMPLETED\n" +
                "006|2025-09-22T12:45|강남|U1006|아메리카노x3||COMPLETED\n" +
                "007|2025-09-22T13:20|강남|U1007|라떼x1;콜드브루x1||REFUNDED\n" +
                "008|2025-10-12T16:00|판교|U1008|카푸치노x1||PLACED"; //<-환불 기능 확인을 위해 8번 추가 

        List<Order> parsedOrders = OrderParser.parseOrders(ORDERS_DATA);
        this.orderStatusService = new OrderStatusService(parsedOrders);
    }

    public void start() {
        while (true) {
            System.out.println("\n--- 📜 주문 현황 관리 ---");
            System.out.println("1. 전체 주문 현황 보기");
            System.out.println("2. 주문 취소 처리"); // [수정 2] 메뉴 이름 변경
            System.out.println("9. 메인 메뉴로 돌아가기");
            System.out.print("➡️ 원하는 기능의 번호를 입력하세요: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    orderStatusService.printAllOrders();
                    break;
                case "2":
                    // [수정 3] 주문 취소 로직을 처리할 새로운 메서드를 호출합니다.
                    handleOrderCancellation();
                    break;
                case "9":
                    System.out.println("메인 메뉴로 돌아갑니다.");
                    return;
                default:
                    System.out.println("⚠️ 잘못된 입력입니다. 다시 입력해주세요.");
                    break;
            }
        }
    }

    /**
     * [추가] 주문 취소 과정을 처리하는 private 헬퍼 메서드
     */
    private void handleOrderCancellation() {
        System.out.print("취소할 주문의 ID를 입력하세요: ");
        String orderIdToCancel = scanner.nextLine();
        
        // 입력값이 비어있는지 확인
        if (orderIdToCancel == null || orderIdToCancel.trim().isEmpty()) {
            System.out.println("⚠️ 주문 ID가 입력되지 않았습니다.");
            return;
        }

        // 서비스의 cancelOrder 메서드를 호출합니다.
        orderStatusService.cancelOrder(orderIdToCancel.trim());
    }
}