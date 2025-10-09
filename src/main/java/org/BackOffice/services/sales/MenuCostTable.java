package org.BackOffice.services.sales;

import org.BackOffice.domain.InMemoryData;
import java.util.Map;

/** 메뉴별 원가 테이블 */
public class MenuCostTable {

    private final Map<InMemoryData.Menu, Integer> costTable = Map.of(
            InMemoryData.Menu.AMERICANO, 700,
            InMemoryData.Menu.LATTE, 1200,
            InMemoryData.Menu.MOCHA, 1500
    );

    public int getCost(InMemoryData.Menu menu) {
        return costTable.getOrDefault(menu, 0);
    }
}
