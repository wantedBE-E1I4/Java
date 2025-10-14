package org.BackOffice.services.core;


import java.util.List;
import java.util.Optional;

/**
 * Entity Repository의 Interface정의
* */
public interface EntityRepository <T> {
    T save(T menu);
    Optional<T> findById(Long id);
    Optional<T> findByName(String name);
    List<T> findAll();
    Optional<T> delete(Long id);
}
