package com.app.domain.base;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, ID> {
    Optional<T> save(T item);
    List<T> saveAll(List<T> items);
    List<T> findAll();
    List<T> findAllById(List<ID> ids);
    Optional<T> findById(ID id);
    Optional<T> delete(ID id);
}
