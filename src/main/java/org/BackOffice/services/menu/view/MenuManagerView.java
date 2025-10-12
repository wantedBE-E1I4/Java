package org.BackOffice.services.menu.view;

import java.util.Scanner;
import org.BackOffice.services.menu.ProductMenu;
import org.BackOffice.services.menu.view.core.AbstractView;
import org.BackOffice.services.menu.view.core.ViewRouter;

public class MenuManagerView extends AbstractView {

    @Override
    public void show() {
        // header
        printHeader("메뉴 관리");
        // body
        printBody();
        // footer
        printFooter("1. 메뉴판 상태관리 \t 2. 메뉴 등록 및 삭제 \t 3. 이전 페이지");
        // router
        Scanner sc = new Scanner(System.in);
        int selection = sc.nextInt();

        switch (selection) {
            case 1 -> {
                ViewRouter.navigatorTo("menuBoardSetting");
            }
            case 2 -> {
                //
            }
            case 3 -> {
                ViewRouter.navigatorTo("productMenu");
            }
        }
    }
}
