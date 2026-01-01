package io.commerce.product.infra.entity;

import io.commerce.product.domain.ProductStatus;
import io.commerce.product.domain.model.Product;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "product")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductEntity {

    @Id
    private Long id;
    private String name;
    private Long price;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ProductEntity from(Product product) {
        ProductEntity entity = new ProductEntity();
        entity.id = product.getId();
        entity.name = product.getName();
        entity.price = product.getPrice();
        entity.status = product.getStatus();
        entity.createdAt = product.getCreatedAt();
        entity.updatedAt = product.getUpdatedAt();
        return entity;
    }

    public Product toProduct() {
        return new Product(id, name, price, status, createdAt, updatedAt);
    }
}
