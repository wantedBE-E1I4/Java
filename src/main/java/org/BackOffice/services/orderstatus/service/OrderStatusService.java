package org.BackOffice.services.orderstatus.service;

import org.BackOffice.services.orderstatus.domain.Order;
import org.BackOffice.services.orderstatus.domain.OrderItem;
import org.BackOffice.services.orderstatus.domain.OrderStatus; // OrderStatus import 추가

import java.util.List;

/**
 * 주문 현황 관리와 관련된 핵심 비즈니스 로직을 처리하는 서비스 클래스입니다.
 */
public class OrderStatusService {

    private final List<Order> orders; // 서비스가 관리할 주문 데이터 목록

    public OrderStatusService(List<Order> orders) {
        this.orders = orders;
    }

    /**
     * 기능 1: 현재 모든 주문의 현황을 요청된 형식으로 콘솔에 출력합니다.
     */
    public void printAllOrders() {
        System.out.println("\n[주문 현황]");
        if (orders.isEmpty()) {
            System.out.println("처리할 주문 내역이 없습니다.");
            return;
        }

        for (Order order : orders) {
            // 1. 주문 아이템 요약 문자열 생성
            String itemsSummary;
            List<OrderItem> items = order.items();
            if (items.size() == 1) {
                // 아이템이 하나일 경우
                OrderItem firstItem = items.get(0);
                itemsSummary = String.format("%s %d잔", firstItem.menuName(), firstItem.quantity());
            } else {
                // 아이템이 여러 개일 경우
                OrderItem firstItem = items.get(0);
                itemsSummary = String.format("%s %d잔 외 %d건",
                        firstItem.menuName(), firstItem.quantity(), items.size() - 1);
            }

            // 2. 최종 출력 문자열 생성
            String statusString = order.status().toString();
            if (order.status() == OrderStatus.CANCELLED) {
                // CANCELLED 상태일 경우 추가 정보 표시
                statusString += " (고객 요청)";
            }

            System.out.printf("#%s %s → %s\n",
                    order.orderId(),
                    itemsSummary,
                    statusString);
        }
    }

    /**
     * 기능 2: 'PLACED' 상태의 주문을 'CANCELLED' 상태로 변경합니다.
     * @param orderId 취소할 주문의 ID
     */
    public void cancelOrder(String orderId) {
        // 1. 취소할 주문을 ID로 찾습니다.
        for (int i = 0; i < orders.size(); i++) {
            Order currentOrder = orders.get(i);

            if (currentOrder.orderId().equals(orderId)) {
                // 2. 주문을 찾았으면, 상태를 확인합니다.
                if (currentOrder.status() == OrderStatus.PLACED) {
                    // 3. 'PLACED' 상태가 맞으면, 상태가 변경된 새 Order 객체를 생성합니다.
                    // (record는 불변(immutable)이므로 직접 값을 바꿀 수 없습니다.)
                    Order cancelledOrder = new Order(
                            currentOrder.orderId(),
                            currentOrder.dateTime(),
                            currentOrder.branch(),
                            currentOrder.userId(),
                            currentOrder.items(),
                            currentOrder.couponCode(),
                            OrderStatus.CANCELLED // 상태를 CANCELLED로 변경
                    );

                    // 4. 리스트의 기존 위치에 새로 만든 객체로 덮어씁니다.
                    orders.set(i, cancelledOrder);
                    System.out.printf("✅ 주문 #%s 이(가) 성공적으로 취소되었습니다.\n", orderId);
                    return; // 작업을 완료했으므로 메서드를 종료합니다.
                } else {
                    // 'PLACED' 상태가 아닌 경우
                    System.out.printf("⚠️ 오류: 주문 #%s 은(는) '주문 접수' 상태가 아니므로 취소할 수 없습니다. (현재 상태: %s)\n",
                            orderId, currentOrder.status());
                    return;
                }
            }
        }

        // 5. for문이 끝날 때까지 주문을 찾지 못한 경우
        System.out.println("⚠️ 오류: 해당 ID의 주문을 찾을 수 없습니다: " + orderId);
    }
}