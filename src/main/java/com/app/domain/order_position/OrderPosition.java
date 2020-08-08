package com.app.domain.order_position;

import com.app.domain.base.BaseEntity;
import com.app.domain.order.Order;
import com.app.domain.product.Product;
import com.app.domain.value_objects.Money;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "order_positions")
public class OrderPosition extends BaseEntity {

    private Integer quantity;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "order_id")
    private Order order;

    public Money totalPrice() {
        return product.totalPrice().multiply(quantity);
    }
}
