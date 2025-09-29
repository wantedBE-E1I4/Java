package org.BackOffice;
import java.time.LocalDateTime;
import java.util.*;

/** DB 없이 쓰는 인메모리 저장소 (한 파일) */
public final class InMemoryData {

    /* 1) 메뉴 (가격 포함) */
    public enum Menu {
        AMERICANO(2000),
        LATTE(3000),
        MOCHA(3500);

        public final int price;
        Menu(int price) { this.price = price; }
    }

    /* 2) 주문/주문항목 */
    public record OrderLine(Menu menu, int qty) {}
    public record Order(Long id, LocalDateTime orderedAt, List<OrderLine> lines) {}

    /* 3) 레시피: 메뉴 → (원재료명 → 소요량) */
    public static final Map<Menu, Map<String, Integer>> RECIPE = new LinkedHashMap<>();

    /* 4) 원재료 초기 재고: (원재료명 → 보유량) */
    public static final Map<String, Integer> INVENTORY = new LinkedHashMap<>();

    /* 5) 샘플 주문 데이터 */
    public static final List<Order> ORDERS = new ArrayList<>();

    static {
        // 3) 레시피 채우기
        RECIPE.put(Menu.AMERICANO, Map.of(
                "espressoShot", 1,
                "waterMl", 150
        ));
        RECIPE.put(Menu.LATTE, Map.of(
                "espressoShot", 1,
                "milkMl", 180
        ));
        RECIPE.put(Menu.MOCHA, Map.of(
                "espressoShot", 1,
                "milkMl", 150,
                "chocoSyrupPump", 2
        ));

        // 4) 원재료 초기 재고
        INVENTORY.put("espressoShot", 200);
        INVENTORY.put("waterMl", 50_000);
        INVENTORY.put("milkMl", 10_000);
        INVENTORY.put("chocoSyrupPump", 300);

        // 5) 샘플 주문
        ORDERS.add(new Order(
                1L,
                LocalDateTime.now(),
                List.of(
                        new OrderLine(Menu.AMERICANO, 2),
                        new OrderLine(Menu.LATTE, 1)
                )
        ));
        ORDERS.add(new Order(
                2L,
                LocalDateTime.now(),
                List.of(new OrderLine(Menu.MOCHA, 3))
        ));
    }

    private InMemoryData() {}

    /* (선택) 유틸: 주문 총액 계산 */
    public static int calcTotalPrice(Order order) {
        return order.lines().stream()
                .mapToInt(l -> l.menu().price * l.qty())
                .sum();
    }

    /* (선택) 유틸: 재고 차감 시뮬레이션 */
    public static boolean tryConsumeInventory(Order order) {
        // 필요한 원재료 집계
        Map<String, Integer> need = new HashMap<>();
        for (OrderLine line : order.lines()) {
            Map<String, Integer> recipe = RECIPE.get(line.menu());
            if (recipe == null) return false;
            for (Map.Entry<String, Integer> e : recipe.entrySet()) {
                need.merge(e.getKey(), e.getValue() * line.qty(), Integer::sum);
            }
        }
        // 재고 검증
        for (Map.Entry<String, Integer> e : need.entrySet()) {
            int have = INVENTORY.getOrDefault(e.getKey(), 0);
            if (have < e.getValue()) return false; // 부족
        }
        // 차감
        need.forEach((k, v) -> INVENTORY.computeIfPresent(k, (kk, have) -> have - v));
        return true;
    }
}
