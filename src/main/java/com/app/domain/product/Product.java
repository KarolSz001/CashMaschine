package com.app.domain.product;

import com.app.domain.base.BaseEntity;
import com.app.domain.value_objects.Discount;
import com.app.domain.value_objects.Money;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    private String name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "price"))
    })
    private Money price;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "discount"))
    })
    private Discount discount;

    public Money totalPrice() {
        return price.multiply(discount.reverse().toString());
    }

    public String getName() {
        return name;
    }
}
