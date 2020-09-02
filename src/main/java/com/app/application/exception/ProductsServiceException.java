package com.app.application.exception;

import com.app.domain.product.Product;

public class ProductsServiceException extends RuntimeException {
    public ProductsServiceException(String message) {
        super(message);
    }
}
