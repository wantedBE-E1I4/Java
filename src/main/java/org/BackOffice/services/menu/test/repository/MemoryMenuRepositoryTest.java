package org.BackOffice.services.menu.test.repository;

import org.BackOffice.services.menu.repository.MemoryMenuRepository;
import org.BackOffice.services.menu.domain.MenuEntity;
import org.BackOffice.services.menu.domain.MenuStatus;

public class MemoryMenuRepositoryTest {
    private final MemoryMenuRepository repo = new MemoryMenuRepository();

    public static void main(String[] args) {
        MemoryMenuRepositoryTest test = new MemoryMenuRepositoryTest();
        test.saveTest();
        test.findByIdTest();
        test.findAllTest();
        test.deleteTest();
    }

    public void saveTest() {
        repo.clearStore(); // ✅ 테스트 시작 전 초기화
        MenuEntity menu = MenuEntity.createMenuEntity("아메리카노", 2000, MenuStatus.SELLING);
        repo.save(menu);

        MenuEntity result = repo.findById(menu.getId()).orElse(null);
        System.out.println(result != null && result.getMenuName().equals("아메리카노")
                ? "[PASS] saveTest" : "[FAIL] saveTest");
    }

    public void findByIdTest() {
        repo.clearStore(); // ✅ 초기화
        MenuEntity menu = MenuEntity.createMenuEntity("라떼", 3000, MenuStatus.SELLING);
        repo.save(menu);

        MenuEntity result = repo.findById(menu.getId()).orElse(null);
        System.out.println(result != null && result.getMenuPrice() == 3000
                ? "[PASS] findByIdTest" : "[FAIL] findByIdTest");
    }

    public void findAllTest() {
        repo.clearStore(); // ✅ 초기화
        repo.save(MenuEntity.createMenuEntity("아메리카노", 2000, MenuStatus.SELLING));
        repo.save(MenuEntity.createMenuEntity("라떼", 3000, MenuStatus.SELLING));

        int size = repo.findAll().size();
        System.out.println(size == 2 ? "[PASS] findAllTest" : "[FAIL] findAllTest (" + size + ")");
    }

    public void deleteTest() {
        repo.clearStore(); // ✅ 초기화
        MenuEntity menu = MenuEntity.createMenuEntity("모카", 3500, MenuStatus.SELLING);
        repo.save(menu);
        repo.delete(menu.getId());

        boolean deleted = repo.findById(menu.getId()).isEmpty();
        System.out.println(deleted ? "[PASS] deleteTest" : "[FAIL] deleteTest");
    }
}

