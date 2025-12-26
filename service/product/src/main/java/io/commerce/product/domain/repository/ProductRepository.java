package io.commerce.product.domain.repository;

import io.commerce.product.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Optional<Product> findByName(String name);
    void save(Product product);
    void updateProduct(Product product);
    void delete(Product product);
}
