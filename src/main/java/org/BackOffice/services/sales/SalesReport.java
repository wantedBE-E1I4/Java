package org.BackOffice.services.sales;

import java.util.List;

/**
 * SalesReport
 * ─────────────────────────────
 * [역할]
 *  - 매출 분석 결과를 담는 데이터 전달 객체(DTO)
 *
 * [책임]
 *  - 분석 결과 데이터(총 매출, 인기 메뉴, 이익률)를 보관
 *  - UI 또는 상위 서비스에서 출력/표현 용도로 사용
 *
 * [설계 의도 / 객체지향 관점]
 *  - 단일 책임(SRP): 데이터 보관만 담당, 계산/분석 로직 없음
 *  - 불변 객체(Record): 값 변경 불가, 안정적인 데이터 전달 가능
 *  - 재사용성: 다른 서비스에서도 동일 구조로 매출 결과 전달 가능
 *  - 단순성: record가 getter 자동 생성 (totalSales(), topMenus(), profitMargin())
 */
public record SalesReport(
        int totalSales, // 총매출
        List<String> topMenus, // 인기 메뉴 TOP N
        double profitMargin // 이익률(%)
) {}
