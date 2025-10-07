package org.BackOffice.services.loyalty.repository;

import org.BackOffice.services.loyalty.domain.Order;

import java.util.HashMap;
import java.util.Map;

public class OrderRepository {
    private Map<Integer, Order> orderMap = new HashMap<>();
    int seq = 0;

    public void save(Order order) {
        //id 발급
        order.setId(++seq);
        orderMap.put(order.getId(), order);
    }

    public Order findById(int orderId) {
        return orderMap.get(orderId);
    }
}
