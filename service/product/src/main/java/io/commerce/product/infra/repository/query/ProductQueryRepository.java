package io.commerce.product.infra.repository.query;

import io.commerce.product.infra.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductQueryRepository extends JpaRepository<ProductEntity, Long> {

    @Query("select new io.commerce.product.infra.repository.query.ProductWithStockRead( " +
            "            p.id," +
            "            p.name," +
            "            p.price," +
            "            s.quantity" +
            "           ) " +
            "from ProductEntity p " +
            "join ProductStockEntity s " +
            "on p.id = s.productId ")
    List<ProductWithStockRead> findProductList();
}
