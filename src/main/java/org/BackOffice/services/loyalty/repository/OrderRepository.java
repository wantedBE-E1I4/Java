package org.BackOffice.services.loyalty.repository;

import org.BackOffice.services.loyalty.domain.Order;

import java.util.HashMap;
import java.util.Map;

public class OrderRepository {
    private Map<Long, Order> orderMap = new HashMap<>();
    Long seq = 0L;

    public void save(Order order) {
        //id 발급
        order.setId(++seq);
        orderMap.put(order.getId(), order);
    }

    public Order findById(Long orderId) {
        return orderMap.get(orderId);
    }
}
