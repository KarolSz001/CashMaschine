package com.app.domain.product;

import com.app.domain.base.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Override
    Optional<Product> save(Product item);

    @Override
    List<Product> saveAll(List<Product> items);

    @Override
    List<Product> findAll();

    @Override
    List<Product> findAllById(List<Long> longs);

    @Override
    Optional<Product> findById(Long aLong);

    @Override
    Optional<Product> delete(Long aLong);
}
