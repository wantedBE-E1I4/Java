package org.BackOffice.services.menu.view;

import java.util.Scanner;
import org.BackOffice.services.menu.loader.ProductMenuLoader;
import org.BackOffice.services.menu.service.ProductMenuService;

public class MenuRegisterView {
    private static final ProductMenuService pms = new ProductMenuService();

    // test
    public static void main(String[] args) {
        ProductMenuLoader.syncMenuTable();
        MenuRegisterView.view();
    }

    public static void view() {
        System.out.println();
        System.out.println("메뉴 등록");
        System.out.println("등록하고자 하는 메뉴의 이름과 가격을 입력해주세요.");
        System.out.println("예시) 아포가토,6000");
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(",");
        String name = input[0];
        int price = Integer.parseInt(input[1]);

        // 메뉴 등록 로직
        pms.registerNewMenu(name, price);
        System.out.println(name+" 메뉴를 등록했습니다.");
        System.out.println("이전 페이지로 돌아갑니다.");

        AddAndDeleteMenuView.view();

    }
}
