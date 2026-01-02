package io.commerce.order.application.dto;

import lombok.Getter;

@Getter
public class CreateOrderCommand {
    private Long userId;
    private Long orderId;
    private Long productId;
    private Long price;
    private Long quantity;

    public CreateOrderCommand(Long userId, Long orderId, Long productId, Long price, Long quantity) {
        this.userId = userId;
        this.orderId = orderId;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }
}
