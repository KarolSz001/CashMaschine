package com.app.application.validator;

import com.app.application.dto.CreateProductDto;

import java.util.HashMap;
import java.util.Map;

public class CreateProductDtoValidator implements Validator<CreateProductDto> {

    @Override
    public Map<String, String> validate(CreateProductDto createProductDto) {
        var errors = new HashMap<String, String>();

        if  (createProductDto == null) {
            errors.put("object","is null");
        }

        if (!isNameValid(createProductDto.getName())) {
            errors.put("name", "is not correct");
        }

        if (!isPriceValid(createProductDto.getPrice())) {
            errors.put("price", "is not correct");
        }

        if (!isDiscountValid(createProductDto.getDiscount())) {
            errors.put("discount", "is not correct");
        }

        return errors;
    }


    private boolean isNameValid(String name) {
        return name != null && name.matches("[A-Z ]+");
    }

    private boolean isPriceValid(String price) {
        return price != null;
    }

    private boolean isDiscountValid(String discount) {
        return discount != null;
    }
}
