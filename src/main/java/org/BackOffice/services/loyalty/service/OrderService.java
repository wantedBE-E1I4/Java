package org.BackOffice.services.loyalty.service;

import org.BackOffice.services.loyalty.domain.Order;
import org.BackOffice.services.loyalty.domain.OrderStatus;
import org.BackOffice.services.loyalty.repository.OrderRepository;

public class OrderService {
    OrderRepository orderRepo;
    public OrderService(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    /**
     * 주문생성 및 저장
     * @return orderId 반환
     */
    public int createOrder(int guestId) {
        Order order = new Order(guestId);
        orderRepo.save(order);
        return order.getId();
    }

    public Order findOrder(int orderId) {
        return orderRepo.findById(orderId);
    }

    public void saveOrder(Order order) {
        orderRepo.save(order);
    }

    /**
     * 적립금 사용
     * @param points
     */
    public int applyPointsUse(int points, int orderId) {
        Order order = findOrder(orderId);
        order.setTotalPay(points);
        orderRepo.save(order);

        System.out.println("🥳 [" + points + "] 적립 포인트가 사용되었습니다.");
        return points;
    }

    /**
     * Order의 주문 상태를 OPEN -> PAID 변경
     * @param orderId
     */
    public void switchToPaid(int orderId) {
        Order order = findOrder(orderId);
        if (order.getOrderStatus() == OrderStatus.OPEN) {
            order.setOrderStatus(OrderStatus.PAID);
        }
        saveOrder(order);
    }
}
