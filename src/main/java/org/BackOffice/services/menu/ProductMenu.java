package org.BackOffice.services.menu;

import java.util.Scanner;
import org.BackOffice.services.menu.loader.ProductMenuLoader;
import org.BackOffice.services.menu.view.MenuBoardView;
import org.BackOffice.services.menu.view.MenuManagerView;

public class ProductMenu {
    private static final ProductMenu instance = new ProductMenu();
    private boolean initFlag = true;

    // 싱글톤을 위한 생성자
    private ProductMenu() {

    }

    public static ProductMenu getInstance() {
        return instance;
    }

    /**
     * ProductMenu에 진입하기 위한 실행 메서드
    * */
    public void run() {
        // 들어오면 InMemoryData에 있는 정보를 MenuTable에 동기화하기
        if (initFlag) {
            ProductMenuLoader.syncMenuTable();
            initFlag = false;
        }


        // 출력하기
        System.out.println();
        System.out.println("메뉴 관리자");
        System.out.println("1.메뉴판 확인 \t 2.메뉴 관리");
        Scanner sc = new Scanner(System.in);
        int selection = sc.nextInt();


        switch (selection) {
            case 1 -> {
                MenuBoardView.view();
            }
            case 2 -> {
                MenuManagerView.view();
            }
        }

    }
}
