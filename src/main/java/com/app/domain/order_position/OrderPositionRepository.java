package com.app.domain.order_position;

import com.app.domain.base.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrderPositionRepository extends CrudRepository<OrderPosition , Long> {

    @Override
    Optional<OrderPosition> save(OrderPosition item);

    @Override
    List<OrderPosition> saveAll(List<OrderPosition> items);

    @Override
    List<OrderPosition> findAll();

    @Override
    List<OrderPosition> findAllById(List<Long> longs);

    @Override
    Optional<OrderPosition> findById(Long aLong);

    @Override
    Optional<OrderPosition> delete(Long aLong);
}
