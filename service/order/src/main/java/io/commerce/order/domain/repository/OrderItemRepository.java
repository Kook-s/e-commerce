package io.commerce.order.domain.repository;

import io.commerce.order.domain.model.OrderItem;

import java.util.List;
import java.util.Optional;

public interface OrderItemRepository {

    Optional<OrderItem> findById(Long id);
    List<OrderItem> findByOrderId(Long orderId);
    List<OrderItem> findByProductId(Long productId);

    void save(OrderItem orderItem);
}
