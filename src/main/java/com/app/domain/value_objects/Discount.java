package com.app.domain.value_objects;

import com.app.domain.exception.DiscountException;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class Discount {

    private BigDecimal value;

    public Discount(){
        this.value = BigDecimal.ZERO;
    }

    private Discount (BigDecimal value){
        this.value= value;
    }

    public Discount(String value){
        this.value = init(value);
    }

    public Discount reverse() {
        return new Discount(BigDecimal.ONE.subtract(value));
    }

    public BigDecimal init (String value){
        if(value == null || !value.matches("[0-1]\\.\\d+")){
            throw new DiscountException(" wrong arg ");
        }
        var decimalValue = new BigDecimal(value);
        if((decimalValue.compareTo(BigDecimal.ZERO)< 0)|| decimalValue.compareTo(BigDecimal.ONE) > 1){
            throw new DiscountException("wrong range");
        }
        return decimalValue;
    }

}
