package org.BackOffice.services.menu.tables;

import java.util.HashMap;
import java.util.Map;
import org.BackOffice.services.menu.domain.MenuEntity;

public class MenuTable {
    public static Map<Integer, MenuEntity> menuTable = new HashMap<>();
    public static int currentId = 0;
}
