package io.commerce.product.domain.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ProductStock {
    private Long productId;
    private Long quantity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProductStock(Long productId, Long quantity, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.productId = productId;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
