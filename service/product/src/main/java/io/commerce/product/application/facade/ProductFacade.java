package io.commerce.product.application.facade;

import io.commerce.product.application.dto.CreateProductCommand;
import io.commerce.product.application.dto.ProductDetailResult;
import io.commerce.product.application.service.ProductService;
import io.commerce.product.application.service.ProductStockService;
import io.commerce.product.domain.model.Product;
import io.commerce.product.domain.model.ProductStock;
import io.commerce.product.infra.repository.query.ProductQueryRepository;
import io.commerce.product.infra.repository.query.ProductWithStockRead;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductFacade {

    private final ProductService productService;
    private final ProductStockService productStockService;
    private final ProductQueryRepository productQueryRepository;

    public ProductDetailResult getProductDetail(String name) {
        Product product = productService.getProduct(name);
        ProductStock productStock = productStockService.getProductStock(product.getId());
        return ProductDetailResult.of(product, productStock);
    }

    public List<ProductWithStockRead> getProductList() {
        return productQueryRepository.findProductList();
    }

    @Transactional
    public void createProduct(CreateProductCommand command) {
        Long productId = productService.createProduct(command);
        productStockService.createStock(productId);
    }

    @Transactional
    public void deleteProduct(Long productId) {
        Long deleteId = productService.deleteProduct(productId);
        productStockService.deleteStock(deleteId);
    }
}
