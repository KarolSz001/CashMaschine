package com.app.infrastructure.repository.jpa;

import com.app.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<Product, Long> {
}
