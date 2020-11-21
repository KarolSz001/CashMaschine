package com.app.application.dto;

import com.app.domain.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserDto {

    private String username;
    private String email;
    private String password;
    private String passwordConfirmation;
    private Role role;

}
