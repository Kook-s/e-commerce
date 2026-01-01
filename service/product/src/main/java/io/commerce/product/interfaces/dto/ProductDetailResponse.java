package io.commerce.product.interfaces.dto;

import io.commerce.product.application.dto.ProductDetailResult;
import io.commerce.product.domain.model.Product;
import lombok.Getter;

@Getter
public class ProductDetailResponse {
    private Long id;
    private String name;
    private long price;
    private long quantity;

    public static ProductDetailResponse from(ProductDetailResult result) {
        ProductDetailResponse response = new ProductDetailResponse();
        response.id = result.getId();
        response.name = result.getName();
        response.price = result.getPrice();
        response.quantity = result.getQuantity();
        return response;
    }
}
