package org.BackOffice.services.menu.view;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.BackOffice.services.menu.controller.MenuController;
import org.BackOffice.services.menu.domain.MenuEntity;
import org.BackOffice.services.menu.domain.MenuStatus;
import org.BackOffice.services.menu.loader.ProductMenuLoader;
import org.BackOffice.services.menu.service.ProductMenuService;
import org.BackOffice.services.menu.view.core.AbstractView;
import org.BackOffice.services.menu.view.core.ViewRouter;

public class MenuStatusSettingView extends AbstractView {
    private static final MenuController controller = new MenuController();

    @Override
    public void show() {
        // header
        printHeader("상태 변경");
        // body
        List<MenuEntity> data = controller.getMenuList();
        printBody(data);
        // footer
        String[] messages = new String[]{"변경할 메뉴의 ID와 상태를 입력해주세요", "예시) 1,품절"};
        printFooter(messages);
        // update logic
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(",");
        long id = Long.parseLong(input[0]);
        String status = input[1];

        MenuEntity updatedMenu = controller.updateStatus(id, status);
        System.out.println(updatedMenu.getMenuName()+"이(가) " + updatedMenu.getMenuStatus().statusValue+"로 변경되었습니다.");

        // router
        ViewRouter.navigatorTo("menuBoardSetting");
    }
}
