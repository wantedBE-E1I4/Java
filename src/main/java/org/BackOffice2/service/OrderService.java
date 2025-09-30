package org.BackOffice2.service;

import org.BackOffice2.domain.Menu;
import org.BackOffice2.domain.Order;
import org.BackOffice2.domain.OrderLine;
import org.BackOffice2.repository.CafeRepository; // Repository를 사용

import java.util.HashMap;
import java.util.Map;

public class OrderService {

    public int calcTotalPrice(Order order) {
        return order.lines().stream()
                .mapToInt(l -> l.menu().price * l.qty())
                .sum();
    }

    public boolean tryConsumeInventory(Order order) {
        // 1. 필요한 원재료 집계
        Map<String, Integer> need = new HashMap<>();
        for (OrderLine line : order.lines()) {
            // 레시피는 Repository에서 가져온다
            Map<String, Integer> recipe = CafeRepository.RECIPE.get(line.menu());
            if (recipe == null) return false;
            for (Map.Entry<String, Integer> e : recipe.entrySet()) {
                need.merge(e.getKey(), e.getValue() * line.qty(), Integer::sum);
            }
        }

        // 2. 재고 검증 (Repository의 재고와 비교)
        for (Map.Entry<String, Integer> e : need.entrySet()) {
            // Map에서 키에 해당하는 값을 가져오되, 만약 키가 존재하지 않으면 지정된 '기본값'(여기서는 0)을 대신 가져옵니다.
            int have = CafeRepository.INVENTORY.getOrDefault(e.getKey(), 0);
            if (have < e.getValue()) return false;
        }

        // 3. 차감 (Repository의 재고를 변경)
        /**
         * computeIfPresent: 이름 그대로, 맵에 해당 '키'가 존재할 경우에만(ifPresent) 계산을 수행하여 값을 업데이트합니다.
         * (kk, have) -> have - v: kk는 키를, have는 현재 값을 의미합니다.
         * '현재 재고(have)'에서 '필요한 수량(v)'을 빼서 재고를 업데이트하는 계산식입니다.
         */
        need.forEach((k, v) -> CafeRepository.INVENTORY.computeIfPresent(k, (kk, have) -> have - v));
        return true;
    }
}