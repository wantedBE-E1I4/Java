package org.BackOffice.services.menu.parser;

import static org.BackOffice.services.menu.tables.MenuTable.menuTable;

import org.BackOffice.domain.InMemoryData.Menu;
import org.BackOffice.services.menu.domain.MenuEntity;
import org.BackOffice.services.menu.domain.MenuStatus;

public class ProductMenuParser {
    // test
    public static void main(String[] args) {
        syncMenuTable();

        for (Integer i : menuTable.keySet()) {
            System.out.println("menu id : " + i);
            System.out.println("menu name : " + menuTable.get(i).getMenuName());
            System.out.println("menu price : " + menuTable.get(i).getMenuPrice());
            System.out.println("menu status : " + menuTable.get(i).getMenuStatus());
            System.out.println();
        }

    }

    public static void syncMenuTable() {
        Menu[] initMenu = Menu.values();

        for (int i = 1; i <= initMenu.length; i++) {
            Menu menu = initMenu[i-1];

            MenuEntity parseMenu = MenuEntity.createMenuEntity(menu.name(), menu.price, MenuStatus.SELLING);
            menuTable.put(i,parseMenu);
        }
    }
}
