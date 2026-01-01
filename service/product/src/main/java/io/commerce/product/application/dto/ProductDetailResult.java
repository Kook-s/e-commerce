package io.commerce.product.application.dto;

import io.commerce.product.domain.model.Product;
import io.commerce.product.domain.model.ProductStock;
import lombok.Getter;

@Getter
public class ProductDetailResult {
    private Long id;
    private String name;
    private long price;
    private long quantity;

    public static ProductDetailResult of(Product product, ProductStock stock) {
        ProductDetailResult result = new ProductDetailResult();
        result.id = product.getId();
        result.name = product.getName();
        result.price = product.getPrice();
        result.quantity = stock.getQuantity();

        return result;
    }
}
