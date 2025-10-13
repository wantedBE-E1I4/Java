package org.BackOffice.services.menu.view;

import java.util.List;
import java.util.Scanner;
import org.BackOffice.services.menu.controller.MenuController;
import org.BackOffice.services.menu.domain.MenuEntity;
import org.BackOffice.services.menu.view.core.AbstractView;
import org.BackOffice.services.menu.view.core.ViewRouter;

public class MenuDeleteView extends AbstractView {
    public static final MenuController controller = new MenuController();

    @Override
    public void show() {
        // header
        printHeader("메뉴 삭제");

        // body
        List<MenuEntity> data = controller.getMenuList();
        printBody(data);

        // footer
        String[] messages = new String[]{"삭제할 메뉴의 ID번호를 입력해주세요.", "예시) 1"};
        printFooter(messages);

        // logic
        Scanner sc = new Scanner(System.in);
        Long id = sc.nextLong();
        MenuEntity deletedMenu = controller.deleteMenu(id);
        System.out.println(deletedMenu.getMenuName() + "이(가) 삭제되었습니다.");

        // router
        ViewRouter.navigatorTo("menuAddAndDelete");
    }
}
