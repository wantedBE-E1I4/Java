package org.BackOffice.services.loyalty.domain;

import java.util.ArrayList;
import java.util.List;

public class OrderItem {
    private int seq = 0;
    private final int id = ++seq;

    int menuId;
    int quantity;

    public OrderItem(int menuId, int quantity){
        this.menuId = menuId;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }
}
