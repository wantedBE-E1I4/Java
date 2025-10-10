package org.BackOffice.services.loyalty.service;

import org.BackOffice.services.loyalty.domain.Guest;
import org.BackOffice.services.loyalty.domain.Order;
import org.BackOffice.services.loyalty.domain.OrderStatus;
import org.BackOffice.services.loyalty.repository.GuestRepository;
import org.BackOffice.services.loyalty.repository.OrderRepository;

public class OrderService {
    GuestService guestService = new GuestService();

    public Order createOrder(int currentGuestId) {
        return new Order(currentGuestId);
    }

    /**
     * 게스트 생성 + 주문 생성
     */
    public int startOrderForGuest(GuestRepository guestRepository, OrderRepository orderRepository, int guestId) {
        Guest guest = guestService.findGuest(guestRepository, guestId);
        System.out.println("guest.getOpenOrderId() = " + guest.getOpenOrderId()); //결제 완료 후 같은 guestId로 왔을 때 null이어야하는데 //Order의 상태
        if (guest.getOpenOrderId() == null) { // Guest 에 openOrderId 유무 확인
            Order order = createOrder(guestId);// 없으면 Order 생성

            orderRepository.save(order);// 생성한 주문 저장, Id 발급
            guest.setOpenOrderId(order.getId());
            return order.getId();
        }
        return -1;
    }

    public Order findOrder(OrderRepository orderRepository, int orderId) {
        return orderRepository.findById(orderId);
    }

    public void saveOrder(OrderRepository orderRepository, Order order) {
        orderRepository.save(order);
    }

    public void accrueLoyaltyPointsForPaidOrder(GuestRepository guestRepository, OrderRepository orderRepository, int orderId) {
        Order order = findOrder(orderRepository, orderId); //주문 로드
        double points = order.getTotalPay() * 0.10; // 포인트 계산
        System.out.println("👏 결제액 " + order.getTotalPay() + "원, " + points + " 적립 포인트");
        orderRepository.save(order);

        int guestId = order.getGuestId(); //손님 조회
        Guest guest = guestService.findGuest(guestRepository, guestId);
        guest.pointBalance += (int) points;
        guestRepository.save(guest);
    }

    /**
     * Order의 주문 상태를 OPEN -> PAID 변경
     * @param orderRepository
     * @param orderId
     */
    public void switchToPaid(OrderRepository orderRepository, int orderId) {
        Order order = findOrder(orderRepository, orderId);
        if (order.getOrderStatus() == OrderStatus.OPEN) {
            order.setOrderStatus(OrderStatus.PAID);
        }
        saveOrder(orderRepository, order);
    }
}
