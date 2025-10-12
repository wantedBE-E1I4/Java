package org.BackOffice.services.menu.view;

import java.util.Scanner;
import org.BackOffice.services.menu.view.core.AbstractView;
import org.BackOffice.services.menu.view.core.ViewRouter;

public class MenuAddAndDeleteView extends AbstractView {

    @Override
    public void show() {
        // header
        printHeader("메뉴 등록 및 삭제");
        // body
        printBody();
        // footer
        printFooter("1. 신메뉴 등록 \t 2. 메뉴 삭제 \t 3. 이전페이지");
        // router
        Scanner sc = new Scanner(System.in);
        int selection = sc.nextInt();

        switch (selection) {
            case 1 -> {
                ViewRouter.navigatorTo("menuRegister");
            }
            case 2 -> {
                ViewRouter.navigatorTo("menuDelete");
            }
            case 3 -> {
                ViewRouter.navigatorTo("menuBoardSetting");
            }
        }
    }
}
