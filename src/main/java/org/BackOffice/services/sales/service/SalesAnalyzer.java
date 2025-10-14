package org.BackOffice.services.sales.service;

import org.BackOffice.domain.InMemoryData;
import org.BackOffice.services.sales.service.dto.SalesReport;

import java.util.*;
import java.util.stream.Collectors;

/**
 * SalesAnalyzer
 * ─────────────────────────────
 * [역할]
 *  - 매출 데이터를 분석하는 핵심 비즈니스 로직 담당 클래스
 *  - 여러 계산 기능(매출 합계, 인기 메뉴, 이익률)을 조합해 종합 분석 결과를 생성함
 *
 * [책임]
 *  - 매출 관련 데이터를 입력받아 각종 통계(총매출, 인기 메뉴, 이익률) 산출
 *  - 세부 계산 로직은 ProfitCalculator 등 하위 객체에 위임 (SRP 준수)
 *
 * [설계 의도]
 *  - 단일 책임 원칙(SRP): "분석" 자체만 담당하고, 원가 계산은 다른 객체에 맡김
 *  - 개방-폐쇄 원칙(OCP): 분석 항목을 확장(예: 지점별 매출 분석)해도 기존 구조 수정 최소화
 *  - 조합(Composition) 기반 설계: ProfitCalculator 객체를 주입받아 의존성 약화
 */
public class SalesAnalyzer {

    private final List<InMemoryData.Order> orders;
    private final ProfitCalculator profitCalculator;

    /**
     * [생성자]
     * @param orders 분석할 주문 데이터 리스트
     * @param profitCalculator 원가 및 이익률 계산 담당 객체 (의존성 주입)
     */
    public SalesAnalyzer(List<InMemoryData.Order> orders, ProfitCalculator profitCalculator) {
        this.orders = orders;
        this.profitCalculator = profitCalculator;
    }

    /**
     * 매출 분석의 전체 흐름을 수행하고 결과 리포트를 생성
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
     * 총 매출 합계 계산
     * - 주문 목록을 순회하며 각 주문의 총액을 합산
     */
    private int calculateTotalSales() {
        return orders.stream() // 주문 리스트를 스트림으로 변환
                .mapToInt(InMemoryData::calcTotalPrice) // 각 주문의 총액 계산
                .sum(); // 모든 주문의 합계 계산
    }

    /**
     * 인기 메뉴 Top N 계산
     * - 판매 수량 기준으로 내림차순 정렬 후 상위 limit 개 메뉴를 반환
     */
    private List<String> calculateTopMenus(int limit) {
        // 메뉴별 판매수량을 기록하는 Map
        Map<InMemoryData.Menu, Integer> counts = new HashMap<>();


        for (InMemoryData.Order order : orders) {
            // NOTE: order.lines() - order의 필드 lines를 읽기 위한 getter 메서드
            for (InMemoryData.OrderLine line : order.lines()) {
                counts.merge(line.menu(), line.qty(), Integer::sum);

                // NOTE: 이해를 돕기 위한 주석입니다.
                // 아래와 같이 Map에 key 존재 여부를 복잡하게 확인할 필요없이 merge()를 사용해 한 줄로 작성할 수 있습니다.
                /*
                if (counts.containsKey(line.menu())) {
                    counts.put(line.menu(), counts.get(line.menu()) + line.qty());
                } else {
                    counts.put(line.menu(), line.qty());
                }
                */
            }
        }


        //System.out.println(counts); -> 출력 : {MOCHA=3, AMERICANO=2, LATTE=1}
        return counts.entrySet().stream() // 메뉴별 수량을 스트림으로 변환
                .sorted(Map.Entry.<InMemoryData.Menu, Integer>comparingByValue().reversed()) // 판매량 내림차순 정렬
                .limit(limit) // 상위 N개 메뉴 선택
                .map(e -> e.getKey().name()) // 메뉴 이름(String)으로 변환
                .collect(Collectors.toList()); // 리스트로 반환
    }

    /**
     * 이익률(%) 계산
     * - ProfitCalculator를 활용해 총 원가 계산
     * - (매출 - 원가) / 매출 × 100
     * - 매출이 0일 경우 0% 반환
     */
    private double calculateProfitMargin(int totalSales) {
        // 원가 계산
        int totalCost = profitCalculator.calculateTotalCost(orders);

        // 매출이 0이면 0% 반환
        if (totalSales == 0) return 0;

        // 마진 계산
        double profit = totalSales - totalCost;

        // 이익률 계산 및 반환
        return (profit / totalSales) * 100.0;
    }
}
