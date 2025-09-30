package org.BackOffice.orderstatus.service;

import org.BackOffice.orderstatus.domain.Order;
import org.BackOffice.orderstatus.domain.OrderItem;
import org.BackOffice.orderstatus.domain.OrderStatus; // OrderStatus import 추가

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
}