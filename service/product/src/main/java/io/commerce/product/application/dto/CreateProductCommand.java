package io.commerce.product.application.dto;

import lombok.Getter;

@Getter
public class CreateProductCommand {
    private String name;
    private Long price;

}
