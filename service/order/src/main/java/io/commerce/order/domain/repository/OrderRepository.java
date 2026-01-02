package io.commerce.order.domain.repository;

import io.commerce.order.domain.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    Optional<Order> findById(Long id);
    List<Order> findByUserId(Long userId);

    void save(Order order);
}
