package com.app.application.validator;


import com.app.application.dto.CreateOrderDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateOrderDtoValidator implements Validator<CreateOrderDto> {

//    private List<Long> productIds;
//    private List<Integer> quantities;
    @Override
    public Map<String, String> validate(CreateOrderDto createOrderDto) {

        var errors = new HashMap<String, String>();

        if (createOrderDto == null) {
            errors.put("object", "is null");
            return errors;
        }

        if (createOrderDto.getProductIds() == null) {
            errors.put("productsID", "isNULL");
            return errors;
        }


        if (createOrderDto.getQuantities() == null) {
            errors.put("quantities","isNUll");
            return errors;
        }

        if(createOrderDto.getProductIds().size() != createOrderDto.getQuantities().size()){
            errors.put("sizeList","noMatCH");
            return errors;
        }

        if(createOrderDto.getQuantities().stream().anyMatch(quantity -> quantity <= 0)) {
            errors.put("quantities","is zero");
            return errors;
        }

        return errors;
    }

}
