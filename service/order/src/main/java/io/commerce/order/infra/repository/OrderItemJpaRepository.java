package io.commerce.order.infra.repository;

import io.commerce.order.infra.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderItemJpaRepository extends JpaRepository<OrderItemEntity, Long> {

    List<OrderItemEntity> findByOrderId(Long orderId);

    List<OrderItemEntity> findByProductId(Long productId);
}
