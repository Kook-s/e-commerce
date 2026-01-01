package io.commerce.product.interfaces.dto;

import io.commerce.product.application.dto.CreateProductCommand;
import lombok.Getter;

@Getter
public class CreateProductRequest {
    private String name;
    private Long price;

    public CreateProductCommand toCommand() {
        return CreateProductCommand.builder()
                .name(name)
                .price(price)
                .build();
    }
}
