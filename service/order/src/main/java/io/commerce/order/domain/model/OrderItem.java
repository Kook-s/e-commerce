package io.commerce.order.domain.model;

import io.commerce.order.support.error.OrderItemException;
import io.commerce.order.support.error.code.OrderItemErrorCode;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderItem {
    private Long id;
    private Long orderId;
    private Long productId;
    private Long price;
    private Long quantity;

    public static OrderItem create(Long id,Long orderId, Long productId, Long price, Long quantity) {
        return OrderItem.builder()
                .id(id)
                .orderId(orderId)
                .productId(productId)
                .price(price)
                .quantity(quantity)
                .build();
    }

    public void increase(Long quantity) {
        if(quantity == null || quantity == 0) {
            throw new OrderItemException(OrderItemErrorCode.ORDER_INSUFFICIENT_QUANTITY);
        }

        if(this.quantity < quantity) {
            throw new OrderItemException(OrderItemErrorCode.ORDER_INSUFFICIENT_QUANTITY);
        }

        this.quantity += quantity;
    }
}
