package org.BackOffice.services.loyalty.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int seq = 0;
    private final int id = ++seq;
    private final int guestId;
    private static int totalPay = 0;
    private static int totalCups;

    List<OrderItem> items = new ArrayList<>();

    public Order(int guestId) {
        this.guestId = guestId;
    }

    public int getId() {
        return id;
    }

    public void addItem(int menuId, int quantity) {
        OrderItem orderItem = new OrderItem(menuId, quantity);
        items.add(orderItem);
        getTotal(orderItem.quantity, orderItem.price);

    }

    private void getTotal(int quantity, int price) {
        totalPay += (quantity * price);
        totalCups += quantity;
    }

    public int getTotalPay() {
        return totalPay;
    }

    public int getTotalCups() {
        return totalCups;
    }

}
