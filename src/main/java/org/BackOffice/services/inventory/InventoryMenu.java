package org.BackOffice.services.inventory;

import org.BackOffice.domain.InMemoryData;
import org.BackOffice.services.orderstatus.domain.OrderItem;
import org.BackOffice.services.orderstatus.domain.Order;
import org.BackOffice.domain.InMemoryData.Menu;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

import static org.BackOffice.domain.InMemoryData.INVENTORY;


public class InventoryMenu {


    private final List<Order> orders;

    public InventoryMenu(List<Order> orders) {
        this.orders = orders;
    }

    public void printInventoryStatus() {
        System.out.println("--- 실시간 재고 변화 추적 ---");

        Map<String, Integer> menuSales = new HashMap<>();
        Map<String, Integer> currentInventory = new HashMap<>(InMemoryData.INVENTORY);

        for (Order order : this.orders) {
            if (order.status() == org.BackOffice.services.orderstatus.domain.OrderStatus.CANCELLED ||
                    order.status() == org.BackOffice.services.orderstatus.domain.OrderStatus.REFUNDED) {
                continue;
            }



            // 1. 이번 주문으로 인한 재고 변화를 기록할 '문자열 리스트'
            List<String> inventoryChanges = new ArrayList<>();

            // 2. 주문 메뉴별로 판매량 누적 및 재고 계산
            for (OrderItem item : order.items()) {
                menuSales.merge(item.menuName(), item.quantity(), Integer::sum);

                Menu foundMenu = findMenuEnum(item.menuName()); // 메뉴 enum 찾기

                if (foundMenu != null && InMemoryData.RECIPE.containsKey(foundMenu)) {
                    Map<String, Integer> recipe = InMemoryData.RECIPE.get(foundMenu);

                    for (Map.Entry<String, Integer> entry : recipe.entrySet()) {
                        String ingredient = entry.getKey();
                        int amountPerOne = entry.getValue();
                        int consumedAmount = amountPerOne * item.quantity();

                        if (currentInventory.containsKey(ingredient)) {
                            int initialStock = currentInventory.get(ingredient);
                            int finalStock = initialStock - consumedAmount;
                            currentInventory.put(ingredient, finalStock);

                            // 계산 결과를 포맷에 맞는 '문자열'로 만들어서 리스트에 추가
                            String changeLog = String.format("[%s:%d-%d=%d]",
                                    ingredient, initialStock, consumedAmount, finalStock);
                            inventoryChanges.add(changeLog);
                            if (ingredient.equals("espressoShot") && finalStock < 190) {
                                // 경고 메시지를 inventoryChanges 리스트에 추가합니다.
                                inventoryChanges.add("⚠️ 에스프레소 샷 재고 부족! 발주 필요! ⚠️");
                            }

                             if (ingredient.equals("milkMl") && finalStock < 9300) {
                                inventoryChanges.add("⚠️ 우유 재고 부족! 발주 필요! ⚠️");
                            }
                        }
                    }
                }
            }

            // 3. 모든 계산이 끝난 후, 조립된 문자열들을 한번에 출력!
            System.out.printf("%s\n %s\n", menuSales, String.join(", ", inventoryChanges));
        }
    }

    // 메뉴를 찾는 로직을 별도의 메서드로 분리 - 한글로 된 string을 불러오기
    private Menu findMenuEnum(String menuName) {
        switch (menuName) {
            case "아메리카노": return Menu.AMERICANO;
            case "라떼": return Menu.LATTE;
            case "바닐라라떼": return Menu.VANILLALATTE;
            case "콜드브루": return Menu.COLDBREW;
            case "카푸치노": return Menu.CAPPUCCINO;
            default: return null;
        }
    }
}
















