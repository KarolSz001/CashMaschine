package com.app.infrastructure.repository.jpa;

import com.app.domain.order_position.OrderPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOrderPositionRepository extends JpaRepository<OrderPosition,Long> {
}
