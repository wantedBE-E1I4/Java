package org.BackOffice.services.menu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.BackOffice.services.menu.domain.MenuEntity;
import org.BackOffice.services.menu.domain.MenuStatus;
import org.BackOffice.services.menu.repository.MemoryMenuRepository;
import org.BackOffice.services.menu.repository.MenuRepository;

/*
* [역할]
* - 메뉴들을 관리하기 위한 비즈니스 서비스들을 제공합니다.
*
* [책임]
* - 메뉴 관련 비즈니스 로직들을 제공한다.
*
* [설계의도]
* - Repository와 연결되어 데이터를 다룹니다.
*
* */
public class ProductMenuService {
    private final MenuRepository repo = new MemoryMenuRepository();

    /**
     * 메뉴판에 제공되고 있는 메뉴들을 반환합니다.
     * @return 삭제 상태를 제외한 메뉴 리스트
    * */
    public List<MenuEntity> getMenuList() {
        // 삭제 상태의 메뉴는 보여주지 않아야 함 !
        List<MenuEntity> findMenuList = repo.findAll();
        findMenuList.removeIf(menuEntity -> menuEntity.getMenuStatus().statusCode == 4);
        return findMenuList;
    }

    /**
     * 메뉴의 가격을 변경합니다.
     * @param id 메뉴의 id값
     * @param price 변경하고자 하는 가격
     * @return 변경된 값의 MenuEntity
    * */
    public MenuEntity updateMenuPrice(long id, int price) {
        MenuEntity findEntity = repo.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 메뉴입니다.")
        );

        findEntity.setMenuPrice(price);

        return repo.save(findEntity);
    }

    /**
     * 메뉴의 상태를 변경합니다.
     * @param id 메뉴의 id값
     * @param status MenuStatus의 값
     * @return 변경된 값의 MenuEntity
    * */
    public MenuEntity updateMenuStatus(long id, MenuStatus status) {
        MenuEntity findEntity = repo.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 메뉴입니다.")
        );

        findEntity.setMenuStatus(status);

        return repo.save(findEntity);
    }

    /**
     * 새로운 메뉴를 등록합니다.
     * @param name 새로 등록할 메뉴의 이름
     * @param price 등록할 메뉴의 가격
     * @return 새로 등록된 MenuEntity
    * */
    public MenuEntity registerNewMenu(String name, int price) {
        if (repo.findByName(name).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 메뉴입니다: " + name);
        }

        MenuEntity newMenu = MenuEntity.createMenuEntity(name, price, MenuStatus.NEW);
        return repo.save(newMenu);
    }

    /**
     * 메뉴를 삭제합니다.
     * @param id 삭제할 메뉴의 id값
     * @return 삭제된 menu의
    * */
    public MenuEntity removeMenu(long id) {
        MenuEntity deletedMenu = repo.delete(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 메뉴입니다.")
        );

        return deletedMenu;
    }
}
