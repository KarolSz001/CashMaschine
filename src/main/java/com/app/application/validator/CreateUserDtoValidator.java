package com.app.application.validator;

import com.app.application.dto.CreateUserDto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// username nie moze byc null
// email nie moze byc null
// role nie moze byc null
// password oraz passwordConfirmation musza byc takie same
public class CreateUserDtoValidator implements Validator<CreateUserDto> {

    @Override
    public Map<String, String> validate(CreateUserDto createUserDto) {
        var errors = new HashMap<String,String>();

        if(createUserDto == null){
            errors.put("OBJECT","IS NULL");
            return errors;
        }

        if (createUserDto.getUsername() == null){
            errors.put("USERNAME","IS NULL");
            return errors;
        }
        if (createUserDto.getEmail() == null) {
            errors.put("EMAIL", "IS NULL");
            return errors;
        }

        if (createUserDto.getRole() == null) {
            errors.put("ROLE", "IS NULL");
            return errors;
        }

        if (!Objects.equals(createUserDto.getPassword(), createUserDto.getPasswordConfirmation())){
            errors.put("PASSWORD","NO MATCH");
            return errors;
        }
        return errors;
    }
}
