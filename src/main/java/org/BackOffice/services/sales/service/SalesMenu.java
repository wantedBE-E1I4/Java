package org.BackOffice.services.sales.service;

import org.BackOffice.domain.InMemoryData;
import org.BackOffice.services.sales.service.dto.SalesReport;
import org.BackOffice.services.sales.domain.MenuCostTable;

public class SalesMenu {

    /**
     * 매출 분석 결과를 출력한다.
     * - CLI 진입점, 입/출력 책임
     */
    public void printSalesReport() {
        System.out.println("\n[매출 분석]");

        // 매출 분석
        SalesAnalyzer analyzer = new SalesAnalyzer(
                InMemoryData.ORDERS,
                new ProfitCalculator(new MenuCostTable())
        );

        // 매출 분석 결과
        SalesReport report = analyzer.analyze();

        System.out.printf("총 매출: %,d원%n", report.totalSales());
        System.out.print("인기 메뉴 Top 3: ");
        for (int i = 0; i < report.topMenus().size(); i++) {
            System.out.printf("%d) %s  ", i + 1, report.topMenus().get(i));
        }
        System.out.println();
        System.out.printf("이익률: %.1f%%%n", report.profitMargin());
    }
}