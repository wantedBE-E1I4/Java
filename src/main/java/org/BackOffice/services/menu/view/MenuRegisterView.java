package org.BackOffice.services.menu.view;

import java.util.Scanner;
import org.BackOffice.services.menu.controller.MenuController;
import org.BackOffice.services.menu.domain.MenuEntity;
import org.BackOffice.services.menu.view.core.AbstractView;
import org.BackOffice.services.menu.view.core.ViewRouter;

public class MenuRegisterView extends AbstractView {
    private static final MenuController controller = new MenuController();

    @Override
    public void show() {
        // header
        printHeader("메뉴 등록");

        // body
        printBody(" ");

        // footer
        String[] messages = new String[]{"등록하고자 하는 메뉴의 이름과 가격을 입력해주세요.", "예시) 아포가토, 6000"};
        printFooter(messages);

        // register logic
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(",");
        String name = input[0];
        int price = Integer.parseInt(input[1]);

        MenuEntity newMenu = controller.registerMenu(name, price);
        System.out.println("새로운 메뉴 '" +newMenu.getMenuName()+"'가 등록되었습니다.");

        // router
        ViewRouter.navigatorTo("menuAddAndDelete");
    }
}
