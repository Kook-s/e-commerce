package io.commerce.product.domain.repository;

import io.commerce.product.domain.model.ProductStock;

import java.util.Optional;

public interface ProductStockRepository {
    Optional<ProductStock> findById(Long id);

    void increaseStock(Long productId, long quantity);
    void decreaseStock(Long productId, long quantity);

    void save(ProductStock productStock);
    void delete(Long productId);
}
