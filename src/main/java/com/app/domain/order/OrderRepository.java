package com.app.domain.order;

import com.app.domain.base.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Long> {

    @Override
    Optional<Order> save(Order item);

    @Override
    List<Order> saveAll(List<Order> items);

    @Override
    List<Order> findAll();

    @Override
    List<Order> findAllById(List<Long> longs);

    @Override
    Optional<Order> findById(Long aLong);

    @Override
    Optional<Order> delete(Long aLong);
}
