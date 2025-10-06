package org.BackOffice.services.loyalty.service;

import org.BackOffice.services.loyalty.domain.Guest;
import org.BackOffice.services.loyalty.domain.Order;
import org.BackOffice.services.loyalty.repository.GuestRepository;
import org.BackOffice.services.loyalty.repository.OrderRepository;

public class OrderService {
    GuestService guestService = new GuestService();
    OrderRepository orderRepository = new OrderRepository();

    public Order createOrder(int currentGuestId) {
        Order order = new Order(currentGuestId);
        return order;
    }

    /**
     * 게스트 생성 + 주문 생성
     */
    public int startOrderForGuest(GuestRepository guestRepository, int guestId) {
        Guest guest = guestService.findGuest(guestRepository, guestId);

        if (guest.getOpenOrderId() == null) { // Guest 에 openOrderId 유무 확인
            Order order = createOrder(guestId);// 없으면 Order 생성

            orderRepository.save(order);// 생성한 주문 저장, Id 발급
            guest.setOpenOrderId(order.getId());
            return order.getId();
        }
        return -1;
    }

    public Order findOrder(int orderId) {
        return orderRepository.findById(orderId);
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }
}
