package org.BackOffice.services.menu.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.BackOffice.services.menu.domain.MenuEntity;

public class MemoryMenuRepository implements MenuRepository{

    private static Map<Long, MenuEntity> menuStore = new HashMap<>();
    private static Long autoIncrement = 0L;

    @Override
    public MenuEntity save(MenuEntity menu) {
        menuStore.put(++autoIncrement,menu);
        return menu;
    }

    @Override
    public Optional<MenuEntity> findById(Long id) {
        return Optional.ofNullable(menuStore.get(id));
    }

    @Override
    public Optional<MenuEntity> findByName(String name) {
        return menuStore.values().stream()
                .filter(menu -> menu.getMenuName().equals(name))
                .findAny();
    }

    @Override
    public List<MenuEntity> findAll() {
        return new ArrayList<>(menuStore.values());
    }

    @Override
    public Optional<MenuEntity> delete(Long id) {
        MenuEntity deletedEntity = menuStore.remove(id);
        return Optional.ofNullable(deletedEntity);
    }

    // 테스트 전용 초기화
    public void clearStore() {
        menuStore.clear();
    }

}
