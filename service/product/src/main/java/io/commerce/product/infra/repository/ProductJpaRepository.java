package io.commerce.product.infra.repository;

import aj.org.objectweb.asm.commons.Remapper;
import io.commerce.product.infra.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {

    Optional<ProductEntity> findByName(String name);
    boolean existsByName(String name);
}
