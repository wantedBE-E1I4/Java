package org.BackOffice.services.menu.service;

import static org.BackOffice.services.menu.tables.MenuTable.currentId;
import static org.BackOffice.services.menu.tables.MenuTable.menuTable;

import java.util.HashMap;
import java.util.Map;
import org.BackOffice.services.menu.domain.MenuEntity;
import org.BackOffice.services.menu.domain.MenuStatus;

public class ProductMenuService {
    public Map<Integer, MenuEntity> getMenuList() {
        // 삭제 상태의 메뉴는 보여주지 않아야 함 !
        Map<Integer, MenuEntity> response = new HashMap<>();
        for (Integer key : menuTable.keySet()) {
            MenuEntity data = menuTable.get(key);
            if (data.getMenuStatus().statusValue != 4) {
                response.put(key, data);
            }
        }
        return response;
    }

    public MenuEntity updateMenuPrice(int id, int price) {
        MenuEntity findEntity = menuTable.get(id);
        findEntity.setMenuPrice(price);

        return findEntity;
    }

    public MenuEntity updateMenuStatus(int id, MenuStatus status) {
        MenuEntity findEntity = menuTable.get(id);
        findEntity.setMenuStatus(status);

        return findEntity;
    }

    public void registerNewMenu(String name, int price) {
        MenuEntity newMenu = MenuEntity.createMenuEntity(name,price,MenuStatus.신규);
        menuTable.put(++currentId,newMenu);
    }

    public MenuEntity removeMenu(int id) {
        MenuEntity findMenu = menuTable.get(id);

        menuTable.remove(id);
        return findMenu;
    }
}
