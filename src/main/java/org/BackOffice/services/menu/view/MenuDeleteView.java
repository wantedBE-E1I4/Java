package org.BackOffice.services.menu.view;

import java.util.Map;
import java.util.Scanner;
import org.BackOffice.services.menu.domain.MenuEntity;
import org.BackOffice.services.menu.loader.ProductMenuLoader;
import org.BackOffice.services.menu.service.ProductMenuService;

public class MenuDeleteView {
    public static final ProductMenuService pms = new ProductMenuService();

    // test
    public static void main(String[] args) {
        ProductMenuLoader.syncMenuTable();
        MenuDeleteView.view();
    }

    public static void view() {
        Map<Integer, MenuEntity> menuList = pms.getMenuList();

        System.out.println();
        System.out.println("메뉴 삭제");
        System.out.println("메뉴ID \t 이름 \t 상태값");

        StringBuilder sb = new StringBuilder();
        for (int key : menuList.keySet()) {
            MenuEntity menu = menuList.get(key);
            sb.append(key).append("\t").append(menu.getMenuName()).append("\t").append(menu.getMenuStatus());
            sb.append("\n");
        }
        System.out.println(sb);

        System.out.println("삭제할 메뉴의 ID번호를 입력해주세요.");
        System.out.println("예시) 1");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();

        // 삭제 로직
        MenuEntity deletedMenu = pms.removeMenu(id);
        if (deletedMenu == null) {
            MenuDeleteView.view();
        }
        System.out.println(deletedMenu.getMenuName() +"이(가) 삭제되었습니다.");
        System.out.println("이전 페이지로 돌아갑니다.");
        AddAndDeleteMenuView.view();

    }
}
