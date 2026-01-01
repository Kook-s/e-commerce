package io.commerce.product.interfaces.dto;

import io.commerce.product.domain.ProductStatus;
import io.commerce.product.domain.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ProductResponse {
    private Long id;
    private String name;
    private Long price;
    private ProductStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ProductResponse from(Product product) {
        ProductResponse response = new ProductResponse();
        response.id = product.getId();
        response.name = product.getName();
        response.price = product.getPrice();
        response.status = product.getStatus();
        response.createdAt = product.getCreatedAt();
        response.updatedAt = product.getUpdatedAt();

        return response;
    }
}
