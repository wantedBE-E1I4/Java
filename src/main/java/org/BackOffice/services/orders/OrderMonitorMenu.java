package org.BackOffice.services.orders;

// 필요한 domain, parser, service 클래스를 모두 import 합니다.
import org.BackOffice.services.orderstatus.domain.Order;
import org.BackOffice.services.orderstatus.parser.OrderParser;
import org.BackOffice.services.orderstatus.service.OrderStatusService;

import java.util.List;
import java.util.Scanner;

public class OrderMonitorMenu {

    private OrderStatusService orderStatusService;
    private final Scanner scanner = new Scanner(System.in);

    // [수정 1] 생성자 코드를 변경합니다.
    public OrderMonitorMenu() {
        // 이 메뉴가 생성될 때, 스스로 데이터를 파싱하고 서비스를 준비하도록 합니다.
        initializeService();
    }

    /**
     * 데이터를 파싱하고 OrderStatusService를 초기화하는 메서드
     */
    private void initializeService() {
        String ORDERS_DATA = "# orderId|datetime|branch|userId|items|couponCode|status\n" +
                "001|2025-09-22T09:05|강남|U1001|아메리카노x2;라떼x1||COMPLETED\n" +
                "002|2025-09-22T09:17|강남|U1002|바닐라라떼x1||CANCELLED\n" +
                "003|2025-09-22T10:02|홍대|U1003|아메리카노x1;카푸치노x1||COMPLETED\n" +
                "004|2025-09-22T10:35|강남|U1004|라떼x2;바닐라라떼x1|WELCOME5|COMPLETED\n" +
                "005|2025-09-22T11:10|홍대|U1005|콜드브루x2||COMPLETED\n" +
                "006|2025-09-22T12:45|강남|U1006|아메리카노x3||COMPLETED\n" +
                "007|2025-09-22T13:20|강남|U1007|라떼x1;콜드브루x1||REFUNDED";

        List<Order> parsedOrders = OrderParser.parseOrders(ORDERS_DATA);
        this.orderStatusService = new OrderStatusService(parsedOrders);
    }
    
    // [수정 2] ManagerDashboard에서 호출할 시작 메서드를 만듭니다.
    /**
     * 주문 현황 관리 메뉴를 시작하는 메서드
     */
    public void start() {
        while (true) {
            System.out.println("\n--- 📜 주문 현황 관리 ---");
            System.out.println("1. 전체 주문 현황 보기");
            System.out.println("2. 주문 상태 변경하기 (구현 예정)");
            System.out.println("9. 메인 메뉴로 돌아가기");
            System.out.print("➡️ 원하는 기능의 번호를 입력하세요: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    orderStatusService.printAllOrders();
                    break;
                case "2":
                    System.out.println("주문 상태 변경 기능은 현재 개발 중입니다.");
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
}