package com.app.domain.order;

import com.app.domain.base.BaseEntity;
import com.app.domain.order_position.OrderPosition;
import com.app.domain.value_objects.Money;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "orders")
@Getter
public class Order extends BaseEntity {

    private LocalDate date;


    @OneToMany(mappedBy="order")
    private List<OrderPosition> orderPositions;

    public Money totalPrice(){
        return orderPositions
                .stream()
                .map(OrderPosition::totalPrice)
                .reduce(new Money(), Money::add);

    }
}
