package io.commerce.product.infra.repository.impl;

import io.commerce.common.snowflake.Snowflake;
import io.commerce.product.domain.model.Product;
import io.commerce.product.domain.repository.ProductRepository;
import io.commerce.product.infra.entity.ProductEntity;
import io.commerce.product.infra.repository.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
    private final Snowflake snowflake = new Snowflake();
    private final ProductJpaRepository productJpaRepository;

    @Override
    public List<Product> findAll() {
        return productJpaRepository.findAll().stream()
                .map(ProductEntity::toProduct)
                .toList();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void delete(Product product) {

    }
}
