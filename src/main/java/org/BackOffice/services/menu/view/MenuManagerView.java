package org.BackOffice.services.menu.view;

import java.util.Scanner;
import org.BackOffice.services.menu.ProductMenu;

public class MenuManagerView {
    // Test를 위한 main 메서드
    public static void main(String[] args) {
        view();
    }
    public static void view() {
        ProductMenu pm = new ProductMenu();

        // 출력 화면
        System.out.println();
        System.out.println("메뉴 관리");
        System.out.println("1. 메뉴판 상태관리 \t 2. 메뉴 등록 및 삭제 \t 3. 이전 페이지");
        Scanner sc = new Scanner(System.in);
        int selection = sc.nextInt();


        switch (selection) {
            case 1 -> {
                System.out.println("메뉴판 상태관리");
            }
            case 2 -> {
                System.out.println("메뉴 등록");
            }
            case 3 -> {
                pm.run();
            }
        }
    }
}
