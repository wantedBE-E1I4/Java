package org.BackOffice.services.menu.controller;

import java.util.List;
import org.BackOffice.services.menu.domain.MenuEntity;
import org.BackOffice.services.menu.domain.MenuStatus;
import org.BackOffice.services.menu.service.ProductMenuService;

public class MenuController {
    private final ProductMenuService pms = new ProductMenuService();

    public List<MenuEntity> getMenuList() {
        return pms.getMenuList();
    }

    public MenuEntity updatePrice(Long id, int price) {
        MenuEntity updatedMenu = pms.updateMenuPrice(id, price);
        return updatedMenu;
    }

    public MenuEntity updateStatus(Long id, String updateStatus) {
        MenuStatus status = null;
        for (MenuStatus statusValue : MenuStatus.values()) {
            if (statusValue.statusValue.equals(updateStatus)) {
                status = statusValue;
            }
        }

        MenuEntity updatedMenu = pms.updateMenuStatus(id, status);
        return updatedMenu;
    };

    public MenuEntity registerMenu(String name, int price) {
        MenuEntity newMenu = pms.registerNewMenu(name, price);
        return newMenu;
    }

    public MenuEntity deleteMenu(long id) {
        MenuEntity deletedMenu = pms.removeMenu(id);
        return deletedMenu;
    }
}
