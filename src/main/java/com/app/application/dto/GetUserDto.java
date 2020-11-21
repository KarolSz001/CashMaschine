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
public class GetUserDto {

    private Long idUser;
    private String username;
    private String password;
    private String email;
    private Role role;
}
