package com.app.infrastructure.controller;

import com.app.application.dto.CreateOrderDto;
import com.app.application.dto.GetOrderDto;
import com.app.application.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrdersController {

    private final OrderService orderService;

    @PostMapping
    public Long creatOrder(@RequestBody CreateOrderDto createOrderDto){
        return orderService.createOrder(createOrderDto);
    }

    @GetMapping("/{id}")
    public GetOrderDto getOneOrder(@PathVariable Long id){
        return orderService.createOrder(createOrderDto);
    }

    @GetMapping
    public List<GetOrderDto> getOrders(){
        return orderService.createOrder(createOrderDto);
    }

}
