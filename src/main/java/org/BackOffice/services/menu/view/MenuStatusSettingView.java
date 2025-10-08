package org.BackOffice.services.menu.view;

import java.util.Map;
import java.util.Scanner;
import org.BackOffice.domain.InMemoryData.Menu;
import org.BackOffice.services.menu.domain.MenuEntity;
import org.BackOffice.services.menu.domain.MenuStatus;
import org.BackOffice.services.menu.loader.ProductMenuLoader;
import org.BackOffice.services.menu.service.ProductMenuService;

public class MenuStatusSettingView  {
    private static final ProductMenuService pms = new ProductMenuService();

    // test
    public static void main(String[] args) {
        ProductMenuLoader.syncMenuTable();
        MenuStatusSettingView.view();
    }

    public static void view() {
        Map<Integer, MenuEntity> menuList = pms.getMenuList();

        System.out.println();
        System.out.println("상태 변경");
        System.out.println("메뉴ID \t 이름 \t 상태값");

        StringBuilder sb = new StringBuilder();
        for (int key : menuList.keySet()) {
            MenuEntity menu = menuList.get(key);
            sb.append(key).append("\t").append(menu.getMenuName()).append("\t").append(menu.getMenuStatus());
            sb.append("\n");
        }
        System.out.println(sb);
        sb.setLength(0); // 초기화

        // 상태값 알려주는 테이블
        System.out.println("상태 번호 \t 상태 값");
        for (MenuStatus status : MenuStatus.values()) {
            if (!status.name().equals("삭제")) {
                sb.append(status.statusValue).append(" \t\t\t ").append(status);
                sb.append("\n");
            }

        }
        System.out.println(sb);

        System.out.println("변경할 메뉴의 ID와 상태를 입력해주세요");
        System.out.println("예시) 1,품절");
        Scanner sc = new Scanner(System.in);
        String[] idAndStatus = sc.nextLine().split(",");
        int id = Integer.parseInt(idAndStatus[0].trim());
        String status = idAndStatus[1];
        MenuStatus newStatus;

        switch (status) {
            case "판매중" -> newStatus = MenuStatus.판매중;
            case "품절" -> newStatus = MenuStatus.품절;
            case "신규" -> newStatus = MenuStatus.신규;
            case "삭제" -> newStatus = MenuStatus.삭제;
            default -> newStatus = null;
        }

        if (newStatus == null) {
            System.out.println("없는 상태값을 입력했습니다. 다시 시도해주세요");
            MenuStatusSettingView.view();
        }

        // 수정 로직
        MenuEntity updatedMenu = pms.updateMenuStatus(id, newStatus);
        System.out.println(updatedMenu.getMenuName() + "을(를) " + updatedMenu.getMenuStatus()+ "로 변경하였습니다.");

        // 이전 페이지로 이동
        MenuBoardSettingView.view();
    }

}
