package com.app.application.service;


import com.app.application.dto.CreateUserDto;
import com.app.application.dto.GetOrderDto;
import com.app.application.dto.GetUserDto;
import com.app.application.exception.OrderServiceException;
import com.app.application.exception.UserServerException;
import com.app.application.mapper.Mappers;
import com.app.application.validator.CreateOrderDtoValidator;
import com.app.application.validator.CreateUserDtoValidator;
import com.app.domain.order_position.OrderPosition;
import com.app.domain.user.User;
import com.app.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;


    public Long createUser (CreateUserDto createUserDto){

        var createUserDtoValid = new CreateUserDtoValidator();

        var errors = createUserDtoValid.validate(createUserDto);

        if(!errors.isEmpty()){
            var errorMessage = errors
                    .entrySet()
                    .stream()
                    .map(e->e.getKey() + " ::::" + e.getValue())
                    .collect(Collectors.joining(","));

            throw new OrderServiceException(errorMessage);
        }


        var user = Mappers.fromCreateUserDtoToGetUserDto(createUserDto);
        return userRepository
                .save(user)
                .map(User::getId)
                .orElseThrow(()-> new OrderServiceException("CANNOT INSERT ORDER TO DB"));

    }

    public List<GetUserDto> getAllUsers(){
        return userRepository
                .findAll()
                .stream()
                .map(Mappers::fromUserToGetUserDto)
                .collect(Collectors.toList());
    }

    public GetUserDto getUserDto(Long id){
        if(id == null){
            throw new IllegalArgumentException("NULL ARG");
        }
        return userRepository
                .findById(id)
                .map(Mappers::fromUserToGetUserDto)
                .orElseThrow(()->new UserServerException("NO FOUND USER"));
    }






}
