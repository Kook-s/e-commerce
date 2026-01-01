package io.commerce.product.application.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateProductCommand {
    private String name;
    private Long price;

}
