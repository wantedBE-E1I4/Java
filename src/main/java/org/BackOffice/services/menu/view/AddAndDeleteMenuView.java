package org.BackOffice.services.menu.view;

import java.util.Scanner;

public class AddAndDeleteMenuView {
    // test
    public static void main(String[] args) {
        AddAndDeleteMenuView.view();
    }
    public static void view() {
        System.out.println();
        System.out.println("메뉴 등록 및 삭제");
        System.out.println("1. 신메뉴 등록 \t 2. 메뉴 삭제 \t 3. 이전페이지");
        Scanner sc = new Scanner(System.in);
        int selection = sc.nextInt();

        switch (selection) {
            case 1 -> {
                MenuRegisterView.view();
            }
            case 2 -> {
                MenuDeleteView.view();
            }
            case 3 -> {
                // 이전 페이지
                MenuManagerView.view();
            }
        }
    }
}
