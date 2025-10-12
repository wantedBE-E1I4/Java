package org.BackOffice.services.menu.view;

import java.util.List;
import java.util.Scanner;
import org.BackOffice.services.menu.controller.MenuController;
import org.BackOffice.services.menu.domain.MenuEntity;
import org.BackOffice.services.menu.loader.ProductMenuLoader;
import org.BackOffice.services.menu.service.ProductMenuService;
import org.BackOffice.services.menu.view.core.AbstractView;
import org.BackOffice.services.menu.view.core.ViewRouter;

public class MenuBoardView extends AbstractView {
    private final MenuController controller = new MenuController();


    @Override
    public void show() {
        // header
        printHeader("메뉴판");

        // body
        List<MenuEntity> data = controller.getMenuList();
        printBody(data);

        // footer
        printFooter("1. 뒤로가기");

        // router
        Scanner sc = new Scanner(System.in);
        int selection = sc.nextInt();
        switch (selection) {
            case 1 -> ViewRouter.navigatorTo("productMenu");
        }
    }
}
