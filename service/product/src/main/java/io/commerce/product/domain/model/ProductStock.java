package io.commerce.product.domain.model;

import io.commerce.product.support.error.ProductStockException;
import io.commerce.product.support.error.code.ProductStockErrorCode;
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

    public static ProductStock create(Long productId, Long quantity) {
        return new ProductStock(productId, quantity, LocalDateTime.now(), LocalDateTime.now());
    }

    public void increaseQuantity(Long quantity) {
        if(quantity == null || quantity == 0) {
            throw new ProductStockException(ProductStockErrorCode.PRODUCT_STOCK_ALREADY_INITIALIZED);
        }
        this.quantity += quantity;
    }

    public void decreaseQuantity(Long quantity) {
        if (this.quantity < 0) {
            throw new ProductStockException(ProductStockErrorCode.PRODUCT_STOCK_ALREADY_INITIALIZED);
        }
        this.quantity -= quantity;

    }
}
