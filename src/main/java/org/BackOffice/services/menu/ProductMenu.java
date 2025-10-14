package org.BackOffice.services.menu;

import java.util.Scanner;
import org.BackOffice.services.menu.loader.ProductMenuLoader;
import org.BackOffice.services.menu.view.core.AbstractView;
import org.BackOffice.services.menu.view.core.ViewRouter;


/*
* [역할]
* - 메뉴 관리자의 진입점
*
* [책임]
* - ManagerDashBoard에서 넘어올 때 안내 메시지 출력
* - 이후 사용자의 선택에 따라 다음 View로 이동
*
* [설계의도]
* - 메뉴판만 확인(1번)
* - 메뉴판의 메뉴에 대한 값들을 설정하는 설정(2번)
* - 2가지로 분류하여 사용자들의 선택을 분리하기 위함
* */
public class ProductMenu extends AbstractView {
    private static boolean INIT_FLAG = true;

    /**
     * ProductMenu에 진입하기 위한 실행 메서드
    * */
    @Override
    public void show() {
        // product menu loader 수행
        if (INIT_FLAG) {
            ProductMenuLoader.syncMenuTable();
            INIT_FLAG = false;
        }

        printHeader("메뉴 관리자");
        printBody("수행하고자 하는 번호를 입력해주세요.");
        printFooter("1.메뉴판 확인 \t 2.메뉴 관리 \t 3. 이전 페이지");
        Scanner sc = new Scanner(System.in);
        int selection = sc.nextInt();

        switch (selection) {
            case 1 -> {
                ViewRouter.navigatorTo("menuBoard");
            }
            case 2 -> {
                ViewRouter.navigatorTo("menuManager");
            }
        }
    }
}
