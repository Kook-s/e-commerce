package io.commerce.product.infra.repository.query;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductWithStockRead {
    private Long id;
    private String name;
    private long price;
    private long quantity;
}
