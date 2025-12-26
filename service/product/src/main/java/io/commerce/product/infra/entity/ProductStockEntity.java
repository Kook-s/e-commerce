package io.commerce.product.infra.entity;

import io.commerce.product.domain.model.ProductStock;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "product_stock")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductStockEntity {

    @Id
    private Long productId;
    private Long quantity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ProductStockEntity from(ProductStock stock) {
        ProductStockEntity entity = new ProductStockEntity();
        entity.productId = stock.getProductId();
        entity.quantity = stock.getQuantity();
        entity.createdAt = stock.getCreatedAt();
        entity.updatedAt = stock.getUpdatedAt();
        return entity;
    }
}
