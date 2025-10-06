package org.BackOffice.services.menu.view;

import java.util.Map;
import java.util.Scanner;
import org.BackOffice.services.menu.ProductMenu;
import org.BackOffice.services.menu.domain.MenuEntity;
import org.BackOffice.services.menu.loader.ProductMenuLoader;
import org.BackOffice.services.menu.service.ProductMenuService;

public class MenuBoardView {
    private static final ProductMenuService pms = new ProductMenuService();
    private static final ProductMenu pm = new ProductMenu();

    // test
    public static void main(String[] args) {
        ProductMenuLoader.syncMenuTable();
        MenuBoardView.view();
    }

    public static void view() {
        Map<Integer, MenuEntity> menuList = pms.getMenuList();

        // 메뉴판 View
        System.out.println();
        System.out.println("메뉴판");
        System.out.println("메뉴ID \t 이름 \t 가격");

        StringBuilder sb = new StringBuilder();
        for (int key : menuList.keySet()) {
            MenuEntity menu = menuList.get(key);
            sb.append(key).append("\t").append(menu.getMenuName()).append("\t").append(menu.getMenuPrice());
            sb.append("\n");
        }
        System.out.println(sb);

        // 선택창 View
        System.out.println("1. 이전 페이지");
        Scanner sc = new Scanner(System.in);
        int selection = sc.nextInt();

        switch (selection) {
            case 1 -> {
                pm.run();
            }
        }


    }

}
