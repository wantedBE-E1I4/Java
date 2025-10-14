package org.BackOffice.services.menu.repository;

import java.util.List;
import java.util.Optional;
import org.BackOffice.services.menu.domain.MenuEntity;

/**
 * Menu 저장소 인터페이스
* */
public interface MenuRepository {
    MenuEntity save(MenuEntity menu);
    Optional<MenuEntity> findById(Long id);
    Optional<MenuEntity> findByName(String name);
    List<MenuEntity> findAll();
    Optional<MenuEntity> delete(Long id);
}
