package com.app.domain.user;

import com.app.domain.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@NoArgsConstructor
@SuperBuilder
@Entity
@Getter
@Table(name = "users")
public class User extends BaseEntity {

    private String username;
    private String password;
    private String email;

    @Enumerated
    private Role role;



}
