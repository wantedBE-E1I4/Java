package org.BackOffice.services.menu.view;

import java.util.Scanner;
import org.BackOffice.services.menu.view.core.AbstractView;
import org.BackOffice.services.menu.view.core.ViewRouter;

public class MenuBoardSettingView extends AbstractView {

    @Override
    public void show() {
        // header
        printHeader("메뉴판 상태관리");
        // body
        printBody();
        // footer
        printFooter("1. 가격 설정 \t 2. 상태 변경 \t 3. 이전페이지");
        // router
        Scanner sc = new Scanner(System.in);
        int selection = sc.nextInt();

        switch (selection) {
            case 1 -> {
                ViewRouter.navigatorTo("menuPriceSetting");
            }
            case 2 -> {
                ViewRouter.navigatorTo("menuStatusSetting");
            }
            case 3 -> {
                ViewRouter.navigatorTo("menuManager");
            }
        }
    }
}
