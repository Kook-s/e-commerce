package io.commerce.product.application.service;

import io.commerce.common.snowflake.Snowflake;
import io.commerce.product.application.dto.CreateProductCommand;
import io.commerce.product.application.dto.DeleteProductCommand;
import io.commerce.product.domain.model.Product;
import io.commerce.product.domain.repository.ProductRepository;
import io.commerce.product.support.error.ProductException;
import io.commerce.product.support.error.code.ProductErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final Snowflake snowflake;
    private final ProductRepository productRepository;

    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductException(ProductErrorCode.PRODUCT_NOT_FOUND));
    }

    public Product getProduct(String name) {
        return productRepository.findByName(name).orElseThrow(() -> new ProductException(ProductErrorCode.PRODUCT_NOT_FOUND));
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Long createProduct(CreateProductCommand command) {
        if(productRepository.existsByName(command.getName())){
            throw new ProductException(ProductErrorCode.PRODUCT_ALREADY_EXISTS);
        }

        Product product = Product.create(snowflake.nextId(), command.getName(), command.getPrice());
        productRepository.save(product);

        return product.getId();
    }

    public Long deleteProduct(Long id) {
        productRepository.delete(id);
        return id;
    }
}
