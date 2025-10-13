package org.BackOffice.services.menu.view.core;

import static java.awt.SystemColor.menu;

import java.util.List;
import org.BackOffice.services.menu.domain.MenuEntity;

public abstract class AbstractView implements View {
    protected static final int BOX_WIDTH = 40;

    @Override
    public abstract void show();

    protected void printHeader(String title) {
        System.out.println("\n┌" + "─".repeat(BOX_WIDTH) + "┐");
        System.out.printf("│ %-"+BOX_WIDTH+"s │\n", title);
        System.out.println("├" + "─".repeat(BOX_WIDTH) + "┤");
    }

    // 기본 출력물
    protected void printBody() {
        System.out.printf("│ %-"+BOX_WIDTH+"s │\n", "수행하고자 하는 번호를 입력해주세요.");
    }

    // 문자열 전용
    protected void printBody(String message) {
        System.out.printf("│ %-"+BOX_WIDTH+"s │\n", message);
    }

    // 메뉴 리스트 전용
    protected void printBody(List<MenuEntity> menuList) {
        final int ID_WIDTH = 4;
        final int NAME_WIDTH = 20;
        final int PRICE_WIDTH = 10;
        final int TOTAL_WIDTH = ID_WIDTH + NAME_WIDTH + PRICE_WIDTH + 8;

        System.out.printf("│ %-" + (ID_WIDTH - 1) + "s│ %-" + NAME_WIDTH + "s │ %-" + PRICE_WIDTH + "s │\n",
                "ID", "메뉴 이름(상태)", "가격");


        for (MenuEntity menu : menuList) {
            long menuId = menu.getId();
            String nameWithStatus = menu.getMenuName() + "(" + menu.getMenuStatus().statusValue + ")";
            String priceFormatted = String.format("%d원", menu.getMenuPrice());

            System.out.printf("│ %2d │ %-"+NAME_WIDTH+"s │ %"+PRICE_WIDTH+"s │\n",
                    menuId, nameWithStatus, priceFormatted);
        }


    }

    // 한줄만 출력하는 경우
    protected void printFooter(String information) {
        System.out.println("├" + "─".repeat(BOX_WIDTH) + "┤");
        System.out.printf("│ %-"+BOX_WIDTH+"s │\n", information);
        System.out.println("└" + "─".repeat(BOX_WIDTH) + "┘");
    }

    // 여러줄을 출력해야 하는 경우
    protected void printFooter(String[] informationList) {
        System.out.println("├" + "─".repeat(BOX_WIDTH) + "┤");
        for (String info : informationList) {
            System.out.printf("│ %-"+BOX_WIDTH+"s │\n", info);
        }
        System.out.println("└" + "─".repeat(BOX_WIDTH) + "┘");
    }
}
