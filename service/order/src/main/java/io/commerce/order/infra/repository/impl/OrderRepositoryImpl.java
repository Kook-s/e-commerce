package io.commerce.order.infra.repository.impl;

import io.commerce.order.domain.model.Order;
import io.commerce.order.domain.repository.OrderRepository;
import io.commerce.order.infra.entity.OrderEntity;
import io.commerce.order.infra.repository.OrderJpaRepository;
import jdk.jfr.Registered;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Registered
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;

    @Override
    public Optional<Order> findById(Long id) {
        return orderJpaRepository.findById(id).map(OrderEntity::toOrder);
    }

    @Override
    public List<Order> findByUserId(Long userId) {
        return orderJpaRepository.findByUserId(userId).stream()
                .map(OrderEntity::toOrder)
                .toList();
    }

    @Override
    public void save(Order order) {
        orderJpaRepository.save(OrderEntity.from(order));
    }
}
