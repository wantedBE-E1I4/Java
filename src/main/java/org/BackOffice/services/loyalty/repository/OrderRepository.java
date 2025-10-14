package org.BackOffice.services.loyalty.repository;

import org.BackOffice.services.loyalty.domain.Order;

import java.util.HashMap;
import java.util.Map;

public class OrderRepository {
    private Map<Long, Order> orderMap = new HashMap<>();
    Long seq = 0L;

    /**
     * ID 할당+저장
     * <br>-시퀀스 증가로 ID 부여 후 저장
     * @param order
     */
    public void create(Order order) {
        order.setId(++seq);
        orderMap.put(order.getId(), order);
    }

    /**
     * 상태변경+저장
     * <br>-기존 ID 유지한 채 상태만 갱신
     * @param order
     */
    public void update(Order order) {
        orderMap.put(order.getId(), order);
    }

    public Order findById(Long orderId) {
        return orderMap.get(orderId);
    }
}
