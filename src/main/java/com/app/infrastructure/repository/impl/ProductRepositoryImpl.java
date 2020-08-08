package com.app.infrastructure.repository.impl;

import com.app.domain.product.Product;
import com.app.domain.product.ProductRepository;
import com.app.infrastructure.repository.jpa.JpaProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final JpaProductRepository jpaProductRepository;

    @Override
    public Optional<Product> save(Product product) {
        return Optional.of(jpaProductRepository.save(product));
    }

    @Override
    public List<Product> saveAll(List<Product> items) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public List<Product> findAllById(List<Long> longs) {
        return null;
    }

    @Override
    public Optional<Product> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> delete(Long aLong) {
        return Optional.empty();
    }
}
