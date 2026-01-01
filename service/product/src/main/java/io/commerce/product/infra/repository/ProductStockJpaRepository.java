package io.commerce.product.infra.repository;

import io.commerce.product.infra.entity.ProductStockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProductStockJpaRepository extends JpaRepository<ProductStockEntity, Long> {


    @Modifying
    @Query("update ProductStockEntity p " +
            "set p.quantity = p.quantity + :quantity," +
            "p.updatedAt = now() " +
            "where p.productId = :productId ")
    int increaseStock(Long productId, long quantity);

    @Modifying
    @Query("update ProductStockEntity p " +
            "set p.quantity = p.quantity - :quantity," +
            "p.updatedAt = now() " +
            "where p.productId = :productId " +
            "and p.quantity >= :quantity")
    int decreaseStock(Long productId, long quantity);
}
