package org.BackOffice.services.sales;

import org.BackOffice.domain.InMemoryData;
import java.util.*;
import java.util.stream.Collectors;

public class SalesAnalyzer {

    private final List<InMemoryData.Order> orders;
    private final ProfitCalculator profitCalculator;

    public SalesAnalyzer(List<InMemoryData.Order> orders, ProfitCalculator profitCalculator) {
        this.orders = orders;
        this.profitCalculator = profitCalculator;
    }

    /**
     * 전체 분석을 실행한 후 매출 분석 결과를 반환한다.
     * @return SalesReport - 분석 결과 (총매출, TOP N 메뉴, 이익률 계산)
     */
    public SalesReport analyze() {
        // 총 매출 계산
        int totalSales = calculateTotalSales();
        // 인기 메뉴 계산
        List<String> topMenus = calculateTopMenus(3);
        // 이익률 계산
        double profitMargin = calculateProfitMargin(totalSales);

        // 분석 결과 반환
        return new SalesReport(totalSales, topMenus, profitMargin);
    }

    /**
     * 총 매출을 계산한다.
     * @return
     */
    private int calculateTotalSales() {
        return orders.stream()
                .mapToInt(InMemoryData::calcTotalPrice)
                .sum();
    }

    /**
     * 인기 메뉴를 계산한다.
     * @param limit 인기 메뉴 개수
     * @return 인기 메뉴 리스트
     */
    private List<String> calculateTopMenus(int limit) {
        Map<InMemoryData.Menu, Integer> counts = new HashMap<>();
        for (InMemoryData.Order order : orders) {
            for (InMemoryData.OrderLine line : order.lines()) {
                counts.merge(line.menu(), line.qty(), Integer::sum);
            }
        }

        return counts.entrySet().stream()
                .sorted(Map.Entry.<InMemoryData.Menu, Integer>comparingByValue().reversed())
                .limit(limit)
                .map(e -> e.getKey().name())
                .collect(Collectors.toList());
    }

    /**
     * 이익률을 계산한다.
     * @param totalSales
     * @return
     */
    private double calculateProfitMargin(int totalSales) {
        int totalCost = profitCalculator.calculateTotalCost(orders);
        if (totalSales == 0) return 0;
        double profit = totalSales - totalCost;

        return (profit / totalSales) * 100.0;
    }
}
