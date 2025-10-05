package org.BackOffice.services.menu;

import java.util.Scanner;
import org.BackOffice.services.menu.view.menuView;

public class ProductMenu {

    /**
     * ProductMenu에 진입하기 위한 실행 메서드
    * */
    public void run() {
        System.out.println();
        System.out.println("메뉴 관리자");
        System.out.println("1.메뉴판 확인 \t 2.메뉴 관리");
        Scanner sc = new Scanner(System.in);
        int selection = sc.nextInt();


        switch (selection) {
            case 1 -> {
                System.out.println("메뉴판 출력");
                menuView.view();
            }
            case 2 -> {
                System.out.println("메뉴 관리 탭 출력");
            }
        }

    }
}
