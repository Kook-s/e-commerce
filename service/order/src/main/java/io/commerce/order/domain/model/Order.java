package io.commerce.order.domain.model;

import io.commerce.order.domain.OrderStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Order {
    private Long id;
    private Long userId;
    private OrderStatus status;
    private Long totalPrice;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static Order create(Long id, Long userId){
        return Order.builder()
                .id(id)
                .userId(userId)
                .status(OrderStatus.PAYMENT_PENDING)
                .totalPrice(0L)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

}
