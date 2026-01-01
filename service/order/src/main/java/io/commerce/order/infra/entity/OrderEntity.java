package io.commerce.order.infra.entity;

import io.commerce.order.domain.OrderStatus;
import io.commerce.order.domain.model.Order;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "orders")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderEntity {

    @Id
    private Long id;
    private Long userId;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private Long totalPrice;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static OrderEntity from(Order order) {
        OrderEntity entity = new OrderEntity();
        entity.id = order.getId();
        entity.userId = order.getUserId();
        entity.status = order.getStatus();
        entity.totalPrice = order.getTotalPrice();
        entity.createdAt = order.getCreatedAt();
        entity.updatedAt = order.getUpdatedAt();
        return entity;
    }

    public Order toOrder() {
        return Order.builder()
                .id(id)
                .userId(userId)
                .status(status)
                .totalPrice(totalPrice)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}
