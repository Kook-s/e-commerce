package io.commerce.order.infra.repository.impl;

import io.commerce.order.domain.model.OrderItem;
import io.commerce.order.domain.repository.OrderItemRepository;
import io.commerce.order.infra.entity.OrderItemEntity;
import io.commerce.order.infra.repository.OrderItemJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OrderItemRepositoryImpl implements OrderItemRepository {

    private final OrderItemJpaRepository orderItemJpaRepository;

    @Override
    public Optional<OrderItem> findById(Long id) {
        return orderItemJpaRepository.findById(id).map(OrderItemEntity::toOrderItem);
    }

    @Override
    public List<OrderItem> findByOrderId(Long orderId) {
        return orderItemJpaRepository.findByOrderId(orderId).stream()
                .map(OrderItemEntity::toOrderItem)
                .toList();
    }

    @Override
    public List<OrderItem> findByProductId(Long productId) {
        return orderItemJpaRepository.findByProductId(productId).stream()
                .map(OrderItemEntity::toOrderItem)
                .toList();
    }

    @Override
    public void save(OrderItem orderItem) {
        orderItemJpaRepository.save(OrderItemEntity.from(orderItem));
    }
}
