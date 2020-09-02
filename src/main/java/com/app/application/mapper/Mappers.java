package com.app.application.mapper;

import com.app.application.dto.CreateProductDto;
import com.app.application.dto.GetProductDto;
import com.app.domain.product.Product;
import com.app.domain.value_objects.Discount;
import com.app.domain.value_objects.Money;

public interface Mappers {

    static Product fromCreateProductDtoToGetProductDto(CreateProductDto createProductDto) {
        return Product
                .builder()
                .name(createProductDto.getName())
                .price(new Money(createProductDto.getPrice()))
                .discount(new Discount(createProductDto.getDiscount()))
                .build();
    }

    static GetProductDto fromProductToGetProductDto(Product product) {
        return GetProductDto
                .builder()
                .id(product.getId())
                .name(product.getName())
                .totalPrice(product.totalPrice().toString())
                .build();
    }
}
