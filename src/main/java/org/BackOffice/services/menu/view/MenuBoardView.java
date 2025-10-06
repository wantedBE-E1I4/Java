package org.BackOffice.services.menu.view;

import java.util.Scanner;
import org.BackOffice.domain.InMemoryData.Menu;
import org.BackOffice.services.menu.ProductMenu;

public class MenuBoardView {

    public static void view() {
        int menuCount = Menu.values().length;
        ProductMenu pm = new ProductMenu();

        // 메뉴판 View
        System.out.println();
        System.out.println("메뉴판");
        System.out.println("메뉴ID \t 이름 \t 가격");

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= menuCount; i++) {
            sb.append(i).append("\t").append(Menu.values()[i-1]).append("\t").append(Menu.values()[i-1].price);
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
