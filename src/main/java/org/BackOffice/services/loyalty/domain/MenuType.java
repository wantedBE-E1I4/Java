package org.BackOffice.services.loyalty.domain;

public enum MenuType {
    AMERICANO("아메리카노", 2000),
    LATTE("라떼", 3000),
    MOCHA("모카", 3500);

    public final String displayName;
    public final int price;

    MenuType(String displayName, int price) {
        this.displayName = displayName;
        this.price = price;
    }

    public String menuFormatter() {
        return displayName + "|" + price;
    }
}
