package io.commerce.order.infra.repository.impl;

import io.commerce.order.domain.OrderStatus;
import io.commerce.order.domain.model.Order;
import io.commerce.order.domain.repository.OrderRepository;
import io.commerce.order.infra.entity.OrderEntity;
import io.commerce.order.infra.repository.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
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
    public Order save(Order order) {
        orderJpaRepository.save(OrderEntity.from(order));
        return order;
    }

    @Override
    public Optional<Order> findByUserIdAndStatus(Long userId) {
        return orderJpaRepository.findByUserIdAndStatus(userId, OrderStatus.PAYMENT_PENDING).map(OrderEntity::toOrder);
    }

    @Override
    public void updateTotalPrice(Long orderId, Long totalPrice) {
        orderJpaRepository.updateTotalPrice(orderId, totalPrice);
    }
}
