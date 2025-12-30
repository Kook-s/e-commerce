package io.commerce.product.infra.repository.impl;

import io.commerce.common.snowflake.Snowflake;
import io.commerce.product.domain.model.ProductStock;
import io.commerce.product.domain.repository.ProductStockRepository;
import io.commerce.product.infra.entity.ProductStockEntity;
import io.commerce.product.infra.repository.ProductStockJpaRepository;
import io.commerce.product.support.error.ProductStockException;
import io.commerce.product.support.error.code.ProductStockErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductStockRepositoryImpl implements ProductStockRepository {

    private final ProductStockJpaRepository productStockJpaRepository;

    @Override
    public Optional<ProductStock> findById(Long id) {
        return productStockJpaRepository.findById(id).map(ProductStockEntity::toProductStock);
    }

    @Override
    public void increaseStock(Long productId, long quantity) {
        int updated = productStockJpaRepository.increaseStock(productId, quantity);

        if (updated == 0) {
            throw new ProductStockException(ProductStockErrorCode.PRODUCT_STOCK_NOT_FOUND);
        }
    }

    @Override
    public void decreaseStock(Long productId, long quantity) {
        int updated = productStockJpaRepository.decreaseStock(productId, quantity);

        if (updated == 0) {
            throw new ProductStockException(ProductStockErrorCode.PRODUCT_STOCK_NOT_FOUND);
        }
    }

    @Override
    public void save(ProductStock productStock) {
        productStockJpaRepository.save(ProductStockEntity.from(productStock));
    }

    @Override
    public void delete(Long productStockId) {
        productStockJpaRepository.deleteById(productStockId);
    }
}
