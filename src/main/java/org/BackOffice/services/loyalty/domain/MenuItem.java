package org.BackOffice.services.loyalty.domain;

public enum MenuItem {
    AMERICANO(101,"아메리카노", 2000),
    LATTE(102,"라떼", 3000),
    MOCHA(103, "모카", 3500);

    public final int id;
    public final String displayName;
    public final int price;

    MenuItem(int id, String displayName, int price) {
        this.id = id;
        this.displayName = displayName;
        this.price = price;
    }

    public String menuFormatter() {
        return displayName + "|" + price;
    }

    public int getId() {
        return id;
    }
}
