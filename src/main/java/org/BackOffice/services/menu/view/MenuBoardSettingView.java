package org.BackOffice.services.menu.view;

import java.util.Scanner;

public class MenuBoardSettingView {
    // test
    public static void main(String[] args) {
        MenuBoardSettingView.view();
    }
    public static void view() {
        System.out.println();
        System.out.println("메뉴판 상태관리");
        System.out.println("1. 가격 설정 \t 2. 상태 변경 \t 3. 이전페이지");
        Scanner sc = new Scanner(System.in);
        int selection = sc.nextInt();

        switch (selection) {
            case 1 -> {
                MenuPriceSettingView.view();
            }
            case 2 -> {
                MenuStatusSettingView.view();
            }
            case 3 -> {
                // 이전페이지
                MenuManagerView.view();
            }
        }
    }
}
