package com.app.application.mapper;

import com.app.application.dto.*;
import com.app.domain.order.Order;
import com.app.domain.product.Product;
import com.app.domain.user.User;
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

    static GetOrderDto fromOrderToGetOrderDto(Order order) {
        return GetOrderDto
                .builder()
                .id(order.getId())
                .date(order.getDate())
                .totalPrice(order.totalPrice().toString())
                .build();
    }

    static GetUserDto fromUserToGetUserDto (User user){
        return GetUserDto
                .builder()
                .idUser(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
    static User fromCreateUserDtoToGetUserDto(CreateUserDto createUserDto){
        return User.builder()
                .username(createUserDto.getUsername())
                .email(createUserDto.getEmail())
                .password(createUserDto.getPassword())
                .role(createUserDto.getRole())
                .build();
    }


}
