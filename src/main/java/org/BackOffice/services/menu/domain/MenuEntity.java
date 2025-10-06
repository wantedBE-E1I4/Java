package org.BackOffice.services.menu.domain;

public class MenuEntity {
    private String name;
    private int price;
    private MenuStatus status;

    //팩토리 매서드
    private MenuEntity( String name, int price, MenuStatus status) {
        this.name = name;
        this.price = price;
        this.status = status;
    }

    // create MenuEntity
    public static MenuEntity createMenuEntity( String menuName, int menuPrice, MenuStatus menuStatus) {
        return new MenuEntity( menuName, menuPrice, menuStatus);
    }

    // Getter
    public String getMenuName() {
        return this.name;
    }

    public int getMenuPrice() {
        return this.price;
    }

    public MenuStatus getMenuStatus() {
        return this.status;
    }
}
