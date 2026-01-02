package io.commerce.order.application.dto;

import lombok.Getter;

@Getter
public class CreateOrderItemCommand {
    private Long orderId;
    private Long productId;
    private Long price;
    private Long quantity;

    public CreateOrderItemCommand(Long orderId, Long productId, Long price, Long quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }
}
