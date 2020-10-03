package com.app.domain.value_objects;

import com.app.domain.exception.MoneyException;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

// klasa pozwala sprecyzowac byt kwoty pienieznej
// jest immutable
// a zebys ja mogl ja uzywac w innych encjach to musi miec adnotacje:

@Embeddable
public class Money {

    private BigDecimal value;



    public Money() {
        this.value = BigDecimal.ZERO;
    }

    public Money(String value) {
        this.value = init(value);
    }

    private Money(BigDecimal value) {
        this.value = value;
    }

    public Money add(String value) {
        return new Money(this.value.add(init(value)));
    }

    public Money add(Money money) {
        return new Money(this.value.add(money.value));
    }

    public Money multiply(Integer value) {
        return new Money(this.value.multiply(BigDecimal.valueOf(value)));
    }

    public Money multiply(String value) {
        System.out.println(value);
        return new Money(this.value.multiply(init(value)));
    }

    private BigDecimal init(String value) {
//        System.out.println(value);
        if (value == null || !value.matches("(\\d+\\.)?\\d+")) {
            throw new MoneyException("money value is not correct");
        }
        return new BigDecimal(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
