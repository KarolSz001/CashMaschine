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
        return jpaProductRepository.saveAll(items);
    }

    @Override
    public List<Product> findAll() {
        return jpaProductRepository.findAll();
    }

    @Override
    public List<Product> findAllById(List<Long> items) {
        return jpaProductRepository.findAllById(items);
    }

    @Override
    public Optional<Product> findById(Long aLong) {
        return Optional.of(jpaProductRepository.findById(aLong).orElseThrow(()->new NullPointerException("NO FOUND")));
    }

    @Override
    public Optional<Product> delete(Long aLong) {
        var product = findById(aLong);
        jpaProductRepository.deleteById(aLong);
        return product;
    }
}
