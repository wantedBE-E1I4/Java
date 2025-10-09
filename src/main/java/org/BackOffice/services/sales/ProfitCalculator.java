package org.BackOffice.services.sales;

import org.BackOffice.domain.InMemoryData;
import java.util.List;

/**
 * 원가(비용) 계산기
 * - 비용을 MenuCostTable에 요청함
 */
public class ProfitCalculator {

    // 메뉴별 원가 테이블
    private final MenuCostTable costTable;

    public ProfitCalculator(MenuCostTable costTable) {
        this.costTable = costTable;
    }

    public int calculateTotalCost(List<InMemoryData.Order> orders) {
        int total = 0;
        for (InMemoryData.Order order : orders) {
            for (InMemoryData.OrderLine line : order.lines()) {
                int cost = costTable.getCost(line.menu());
                total += cost * line.qty();
            }
        }
        return total;
    }
}
