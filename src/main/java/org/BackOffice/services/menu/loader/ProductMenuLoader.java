package org.BackOffice.services.menu.loader;

import org.BackOffice.domain.InMemoryData.Menu;
import org.BackOffice.services.menu.domain.MenuEntity;
import org.BackOffice.services.menu.domain.MenuStatus;
import org.BackOffice.services.menu.repository.MemoryMenuRepository;
import org.BackOffice.services.menu.repository.MenuRepository;

/*
* [역할]
* - InMemoryData에 있는 Menu 데이터를 로드
*
* [책임]
* - Enum 타입으로 저장되어있는 메뉴 데이터를 Map타입으로 변경
*
* [설계의도]
* - Enum 타입으로 저장된 메뉴 데이터를 추가 삭제 할 수 없어서 menu 패키지 내부에서 데이터 관리를 위해 생성
* - 이후 메뉴 데이터 타입이 변경되면 삭제될 모듈파일
* */
public class ProductMenuLoader {

    private static final MenuRepository repo = new MemoryMenuRepository();

    /**
     * InMemoryData에 있는 MENU를 Map으로 관리하기 위해서 사용하는 메서드
    * */
    public static void syncMenuTable() {
        Menu[] initMenu = Menu.values();

        for (int i = 1; i <= initMenu.length; i++) {
            Menu menu = initMenu[i-1];

            MenuEntity parseMenu = MenuEntity.createMenuEntity(menu.name(), menu.price, MenuStatus.SELLING);

            repo.save(parseMenu);
        }
    }
}
