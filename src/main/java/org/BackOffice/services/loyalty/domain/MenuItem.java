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

    //TODO idx+100 규칙 캡슐화
    public static int findByDisplayIndex(int idx) {
        MenuItem[] values = MenuItem.values();
        for (MenuItem value : values) {
            if ((idx + 100) == value.id) {
                return value.id;
            }
        }
        return -1;
    }
}
