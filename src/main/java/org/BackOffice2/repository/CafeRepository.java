package org.BackOffice2.repository;

import org.BackOffice2.domain.Menu;
import org.BackOffice2.domain.Order;
import org.BackOffice2.domain.OrderLine;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CafeRepository {
    // 데이터 저장소 역할만 수행
    public static final Map<Menu, Map<String, Integer>> RECIPE = new LinkedHashMap<>();
    public static final Map<String, Integer> INVENTORY = new LinkedHashMap<>();
    public static final List<Order> ORDERS = new ArrayList<>();

    // 데이터 초기화
    static {
        RECIPE.put(Menu.AMERICANO, Map.of("espressoShot", 1, "waterMl", 150));
        // ... (나머지 레시피)

        INVENTORY.put("espressoShot", 200);
        // ... (나머지 재고)

        ORDERS.add(new Order(1L, LocalDateTime.now(), List.of(/* ... */)));
        // ... (나머지 샘플 주문)
    }
}