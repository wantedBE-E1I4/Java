package org.BackOffice.services.loyalty.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Long id;
    private final Long guestId;
    private static int totalPay = 0;
    private static int totalCups;
    private OrderStatus orderStatus;

    List<OrderItem> items = new ArrayList<>();

    public Order(Long guestId) {
        this.guestId = guestId;
        this.orderStatus = OrderStatus.OPEN;
    }

    public Long getId() {
        return id;
    }

    public Long getGuestId() {
        return guestId;
    }

    public void addItem(int menuId, int quantity) {
        OrderItem orderItem = new OrderItem(menuId, quantity);
        items.add(orderItem);
        getTotal(orderItem.quantity, orderItem.price);
    }

    public void setId(Long id) {
        this.id = id;
    }

    private void getTotal(int quantity, int price) {
        totalPay += (quantity * price);
        totalCups += quantity;
    }

    public int getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(int point) {
        totalPay -= point;
    }

    public int getTotalCups() {
        return totalCups;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
