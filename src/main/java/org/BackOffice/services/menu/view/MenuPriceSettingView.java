package org.BackOffice.services.menu.view;

import java.util.List;
import java.util.Scanner;
import org.BackOffice.services.menu.controller.MenuController;
import org.BackOffice.services.menu.domain.MenuEntity;
import org.BackOffice.services.menu.view.core.AbstractView;
import org.BackOffice.services.menu.view.core.ViewRouter;

public class MenuPriceSettingView extends AbstractView {
    private static final MenuController controller = new MenuController();

    @Override
    public void show() {
        // header
        printHeader("가격 설정");

        // body
        List<MenuEntity> data = controller.getMenuList();
        printBody(data);

        // footer
        String[] messages = new String[]{"변경할 메뉴의 ID와 가격을 입력해주세요", "예시) 1,3500"};
        printFooter(messages);

        // update logic
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(",");
        long id = Long.parseLong(input[0]);
        int price = Integer.parseInt(input[1]);

        MenuEntity updatedMenu = controller.updatePrice(id, price);
        System.out.println(updatedMenu.getMenuName()+"이(가) " + updatedMenu.getMenuPrice() + "원으로 변경되었습니다.");

        // route
        ViewRouter.navigatorTo("menuBoardSetting");


    }
}
