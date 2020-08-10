package com.app.infrastructure.repository.impl;

import com.app.domain.order_position.OrderPosition;
import com.app.domain.order_position.OrderPositionRepository;
import com.app.infrastructure.repository.jpa.JpaOrderPositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OrderPositionRepositoryImpl implements OrderPositionRepository {

    private final JpaOrderPositionRepository jpaOrderPositionRepository;


    @Override
    public Optional<OrderPosition> save(OrderPosition orderPosition) {

        return Optional.of(jpaOrderPositionRepository.save(orderPosition));
    }

    @Override
    public List<OrderPosition> saveAll(List<OrderPosition> orderPositions) {
        return jpaOrderPositionRepository.saveAll(orderPositions);
    }

    @Override
    public List<OrderPosition> findAll() {
        return jpaOrderPositionRepository.findAll();
    }

    @Override
    public List<OrderPosition> findAllById(List<Long> items) {
        return jpaOrderPositionRepository.findAllById(items);
    }

    @Override
    public Optional<OrderPosition> findById(Long id) {
        return Optional.of(jpaOrderPositionRepository.findById(id).orElseThrow(()->new NullPointerException("NO FOUND")));
    }

    @Override
    public Optional<OrderPosition> delete(Long id) {
        var orderPosition = findById(id);
        jpaOrderPositionRepository.deleteById(id);
        return orderPosition;
    }
}
