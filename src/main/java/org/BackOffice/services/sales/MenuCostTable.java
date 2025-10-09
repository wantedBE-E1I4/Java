package org.BackOffice.services.sales;

import org.BackOffice.domain.InMemoryData;
import java.util.Map;

/**
 * 🧾 MenuCostTable
 * ─────────────────────────────
 * [역할]
 *  - 메뉴별 원가 정보를 관리하는 도메인 테이블 객체
 *
 * [책임]
 *  - 각 메뉴의 원가를 보관하고 제공
 *  - ProfitCalculator 등 상위 계산 객체에서 원가 조회 시 사용
 *
 * [설계 의도 / 객체지향 관점]
 *  - 단일 책임(SRP): 메뉴 원가 데이터 관리만 담당
 *  - 불변 테이블 사용: Map.of로 초기화 → 원가 정보 변경 방지, 안전성 확보
 *  - 재사용성: 여러 서비스에서 동일 원가 데이터를 공유 가능
 *  - 확장성(OCP): 메뉴 추가 시 새로운 Map으로 대체, 기존 코드 최소 변경
 */
public class MenuCostTable {

    /** 메뉴별 원가 정보를 저장하는 Map */
    private final Map<InMemoryData.Menu, Integer> costTable = Map.of(
            InMemoryData.Menu.AMERICANO, 700,
            InMemoryData.Menu.LATTE, 1200,
            InMemoryData.Menu.MOCHA, 1500
    );

    /**
     * 메뉴별 원가 조회
     * @param menu 조회할 메뉴
     * @return 해당 메뉴의 원가, 없으면 0 반환
     */
    public int getCost(InMemoryData.Menu menu) {
        return costTable.getOrDefault(menu, 0);
    }
}
