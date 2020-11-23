package com.app.infrastructure.controller;

import com.app.application.dto.CreateOrderDto;
import com.app.application.dto.CreateUserDto;
import com.app.application.dto.GetOrderDto;
import com.app.application.dto.GetUserDto;
import com.app.application.service.OrderService;
import com.app.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")

public class UsersController {

    private final UserService userService;

    @PostMapping
    public Long creatUser(@RequestBody CreateUserDto createUserDto){
        return userService.createUser(createUserDto);
    }

    @GetMapping
    public List<GetUserDto> getAllOrders() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public GetUserDto getOneOrder(@PathVariable Long id){
        return userService.getUserDto(id);
    }
}
