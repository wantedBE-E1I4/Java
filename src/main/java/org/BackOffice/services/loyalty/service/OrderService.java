package org.BackOffice.services.loyalty.service;

import org.BackOffice.services.loyalty.domain.Order;

public class OrderService {
    public void createOrder(int id) {
        Order order = new Order(id);
    }
}
