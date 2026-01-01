package io.commerce.product.application.dto;

import lombok.Getter;

@Getter
public class CreateProductStockCommand {
    private Long productId;
    private Long quantity;
}
