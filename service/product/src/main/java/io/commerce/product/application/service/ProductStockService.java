package io.commerce.product.application.service;

import io.commerce.common.snowflake.Snowflake;
import io.commerce.product.application.dto.CreateProductStockCommand;
import io.commerce.product.domain.model.ProductStock;
import io.commerce.product.domain.repository.ProductStockRepository;
import io.commerce.product.support.error.ProductStockException;
import io.commerce.product.support.error.code.ProductStockErrorCode;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductStockService {

    private final Snowflake snowflake;
    private final ProductStockRepository productStockRepository;

    public ProductStock getProductStock(Long productId) {
        return productStockRepository.findById(productId).orElseThrow(() -> new ProductStockException(ProductStockErrorCode.PRODUCT_STOCK_NOT_FOUND));
    }

    public void createStock(Long productId) {
        ProductStock productStock = ProductStock.create(productId, 0L);
        productStockRepository.save(productStock);
    }

    @Transactional
    public void increaseStock(Long productId, Long quantity) {
        ProductStock productStock = productStockRepository.findById(productId).orElseThrow(() -> new ProductStockException(ProductStockErrorCode.PRODUCT_STOCK_NOT_FOUND));
        productStock.increaseQuantity(quantity);
        productStockRepository.increaseStock(productId, quantity);
    }

    @Transactional
    public void decreaseStock(Long productId, Long quantity) {
        ProductStock productStock = productStockRepository.findById(productId).orElseThrow(() -> new ProductStockException(ProductStockErrorCode.PRODUCT_STOCK_NOT_FOUND));
        productStock.decreaseQuantity(quantity);
        productStockRepository.decreaseStock(productId, quantity);
    }

    public void deleteStock(Long productId) {
        productStockRepository.delete(productId);
    }

}
