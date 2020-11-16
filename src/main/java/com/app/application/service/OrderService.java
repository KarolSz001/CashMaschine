package com.app.application.service;


import com.app.application.dto.CreateOrderDto;
import com.app.application.exception.OrderServiceException;
import com.app.application.exception.ProductsServiceException;
import com.app.application.validator.CreateOrderDtoValidator;
import com.app.domain.order.Order;
import com.app.domain.order.OrderRepository;
import com.app.domain.order_position.OrderPosition;
import com.app.domain.order_position.OrderPositionRepository;
import com.app.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {


    private final OrderPositionRepository orderPositionRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public Long createOrder(CreateOrderDto createOrderDto) {

        var createOrderDtoValidator = new CreateOrderDtoValidator();

        var errors = createOrderDtoValidator.validate(createOrderDto);
        if(!errors.isEmpty()){
            var errorMessage = errors
                    .entrySet()
                    .stream()
                    .map(e->e.getKey() + " ::::" + e.getValue())
                    .collect(Collectors.joining(","));

            throw new OrderServiceException(errorMessage);
        }

        // w kolekcji productsIds masz id kolejnych produktow, musisz teraz pobrac te produkty z db
        // po pierwsze po to zeby na ich podstawie zrobic order position ale zanim jeszcze to jezeli
        // okaze sie w liscie sa id ktorych nie mozesz przypoarzadkowac do encji w db to wtedy
        // lista bedzie miec mniej eleemntow bo dla tych id nie dostaniesz obiektow
        // musisz sprawdzic czy jak juz pobierzerzesz elementy po id to czy ich ilosc jest taka
        // jak listy id bo jak nie to wyjatek ze podales jakies nieprawidlowe id

        var ids = createOrderDto.getProductIds();
        var products = productRepository.findAllById(ids);

        if(ids.size() != products.size()){
            throw new ProductsServiceException("Wrong sizes of DB");
        }

        var order = orderRepository
                .save(Order
                        .builder()
                        .date(LocalDate.now())
                        .orderPositions(new ArrayList<>())
                        .build())
                .orElseThrow(() -> new OrderServiceException("Cannot create order"));

        var quantities = createOrderDto.getQuantities();
        var orderPositions = IntStream
                .range(0, products.size())
                .boxed()
                .map(idx -> (OrderPosition)OrderPosition
                        .builder()
                        .product(products.get(idx))
                        .order(order)
                        .quantity(quantities.get(idx))
                        .build())
                .collect(Collectors.toList());
        var insertedOrders =  orderPositionRepository.saveAll(orderPositions);
        if (insertedOrders.size() != orderPositions.size()) {
            throw new OrderServiceException("Cannot insert order positions correctly");
        }
        return order.getId();
    }

}