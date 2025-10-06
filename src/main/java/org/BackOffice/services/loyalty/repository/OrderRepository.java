package org.BackOffice.services.loyalty.repository;

import org.BackOffice.services.loyalty.domain.Guest;
import org.BackOffice.services.loyalty.domain.Order;

import java.util.Collection;
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
        Collection<Order> values = orderMap.values();
        for (Order value : values) {
            if (orderId == value.getId()) {
                return value;
            }
        }
        return null;
    }
}
