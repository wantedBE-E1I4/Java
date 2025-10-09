package org.BackOffice.services.menu.view;

import java.util.Map;
import java.util.Scanner;
import org.BackOffice.services.menu.domain.MenuEntity;
import org.BackOffice.services.menu.loader.ProductMenuLoader;
import org.BackOffice.services.menu.service.ProductMenuService;

public class MenuPriceSettingView {
    private static final ProductMenuService pms = new ProductMenuService();

    //test
    public static void main(String[] args) {
        ProductMenuLoader.syncMenuTable();
        MenuPriceSettingView.view();
    }

    public static void view() {
        Map<Integer, MenuEntity> menuList = pms.getMenuList();

        System.out.println();
        System.out.println("가격 설정");
        System.out.println("메뉴ID \t 이름 \t 가격");

        StringBuilder sb = new StringBuilder();
        for (int key : menuList.keySet()) {
            MenuEntity menu = menuList.get(key);
            sb.append(key).append("\t").append(menu.getMenuName()).append("\t").append(menu.getMenuPrice());
            sb.append("\n");
        }
        System.out.println(sb);

        System.out.println("변경할 메뉴의 ID와 가격을 입력해주세요");
        System.out.println("예시) 1,3500");
        Scanner sc = new Scanner(System.in);
        String[] idAndPrice = sc.nextLine().split(",");
        int id = Integer.parseInt(idAndPrice[0]);
        int price = Integer.parseInt(idAndPrice[1].trim());

        // 수정 로직
        MenuEntity updatedMenu = pms.updateMenuPrice(id,price);
        if (updatedMenu == null) {
            MenuPriceSettingView.view();
        }

        // 변경된 가격 알림
        System.out.println(updatedMenu.getMenuName() + "의 가격이 " + updatedMenu.getMenuPrice() + "원으로 변경되었습니다.");
        System.out.println("이전 페이지로 이동합니다.");

        // 이전 페이지로 이동
        MenuBoardSettingView.view();

    }
}
