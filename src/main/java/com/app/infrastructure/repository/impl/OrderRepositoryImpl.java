package com.app.infrastructure.repository.impl;

import com.app.domain.order.Order;
import com.app.domain.order.OrderRepository;
import com.app.infrastructure.repository.jpa.JpaOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final JpaOrderRepository jpaOrderRepository;

    @Override
    public Optional<Order> save(Order order) {
        return Optional.of(jpaOrderRepository.save(order));
    }

    @Override
    public List<Order> saveAll(List<Order> orders) {
        return jpaOrderRepository.saveAll(orders);
    }

    @Override
    public List<Order> findAll() {
        return jpaOrderRepository.findAll();
    }

    @Override
    public List<Order> findAllById(List<Long> items) {
        return jpaOrderRepository.findAllById(items);
    }

    @Override
    public Optional<Order> findById(Long aLong) {
        return Optional.of(jpaOrderRepository.findById(aLong).orElseThrow(()->new NullPointerException("NO RESULT")));
    }

    @Override
    public Optional<Order> delete(Long aLong) {
        var order = findById(aLong);
        jpaOrderRepository.deleteById(aLong);
        return order;
    }
}
