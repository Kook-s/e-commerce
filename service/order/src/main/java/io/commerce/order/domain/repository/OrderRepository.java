package io.commerce.order.domain.repository;

import io.commerce.order.domain.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    Optional<Order> findById(Long id);
    List<Order> findByUserId(Long userId);

    Order save(Order order);

    Optional<Order> findByUserIdAndStatus(Long userId);

    void updateTotalPrice(Long orderId, Long totalPrice);
}
