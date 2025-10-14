package org.BackOffice.services.sales.service;

import org.BackOffice.domain.InMemoryData;
import org.BackOffice.services.sales.domain.MenuCostTable;

import java.util.List;

/**
 * ProfitCalculator
 * ─────────────────────────────
 * [역할]
 *  - 메뉴 원가 정보를 기반으로 주문들의 총 원가와 이익률 계산을 담당
 *
 * [책임]
 *  - 주문 데이터를 순회하며 각 주문 항목별 원가 합산
 *  - SalesAnalyzer 같은 상위 분석 객체에 이익률 계산 결과 제공
 *
 * [설계 의도 / 객체지향 관점]
 *  - 단일 책임(SRP): 원가 계산 로직만 전담
 *  - 의존성 주입(DI): MenuCostTable을 외부에서 주입받아 재사용성과 테스트 용이성 확보
 *  - 조합(Composition): 상위 객체(SalesAnalyzer)와 협력하여 분석 기능 구성
 */
public class ProfitCalculator {

    /** 메뉴별 원가 정보를 제공하는 객체 */
    private final MenuCostTable costTable;

    /**
     * [생성자]
     * @param costTable 메뉴별 원가 정보를 가진 객체 (의존성 주입)
     */
    public ProfitCalculator(MenuCostTable costTable) {
        this.costTable = costTable;
    }

    /**
     * 총 원가 계산
     * - 주문 목록을 순회하며 각 주문 항목의 원가 × 수량 합산
     * - 상위 분석 객체에서 총 매출과 비교해 이익률 계산에 사용
     *
     * @param orders 분석 대상 주문 목록
     * @return 주문들의 총 원가
     */
    public int calculateTotalCost(List<InMemoryData.Order> orders) {
        int total = 0;

        for (InMemoryData.Order order : orders) {
            for (InMemoryData.OrderLine line : order.lines()) {
                // 해당 메뉴의 원가 조회
                int cost = costTable.getCost(line.menu());
                // 원가 x 수량 합산
                total += cost * line.qty();
            }
        }
        return total;
    }
}
