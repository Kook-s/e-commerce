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

    private final ProductJpaRepository productJpaRepository;

    @Override
    public List<Product> findAll() {
        return productJpaRepository.findAll().stream()
                .map(ProductEntity::toProduct)
                .toList();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productJpaRepository.findById(id).map(ProductEntity::toProduct);
    }

    @Override
    public Optional<Product> findByName(String name) {
        return productJpaRepository.findByName(name).map(ProductEntity::toProduct);
    }

    @Override
    public void save(Product product) {
        productJpaRepository.save(ProductEntity.from(product));
    }

    @Override
    public void delete(Long id) {
        productJpaRepository.deleteById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return productJpaRepository.existsByName(name);
    }
}
