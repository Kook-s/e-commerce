package io.commerce.order.domain.model;

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
}
