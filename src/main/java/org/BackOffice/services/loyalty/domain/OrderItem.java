package org.BackOffice.services.loyalty.domain;

public class OrderItem {
    private int seq = 0;
    private final int id = ++seq;

    int menuId;
    int quantity;
    String displayName;
    int price;


    public OrderItem(int menuId, int quantity){
        this.menuId = menuId;
        this.quantity = quantity;
        captureMenuSnapshot();
    }

    private void captureMenuSnapshot() {
        MenuItem[] items = MenuItem.values();
        for (MenuItem item : items) {
            if (menuId == item.id) {
                this.displayName = item.displayName;
                this.price = item.price;
            }
        }
    }
}
