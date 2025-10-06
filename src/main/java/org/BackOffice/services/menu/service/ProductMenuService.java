package org.BackOffice.services.menu.service;

import static org.BackOffice.services.menu.tables.MenuTable.menuTable;

import java.util.Map;
import org.BackOffice.services.menu.domain.MenuEntity;

public class ProductMenuService {
    public Map<Integer, MenuEntity> getMenuList() {
        return menuTable;
    }
}
