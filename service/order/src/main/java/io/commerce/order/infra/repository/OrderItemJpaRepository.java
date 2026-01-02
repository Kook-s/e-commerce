package io.commerce.order.infra.repository;

import io.commerce.order.infra.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderItemJpaRepository extends JpaRepository<OrderItemEntity, Long> {

    List<OrderItemEntity> findByOrderId(Long orderId);

    List<OrderItemEntity> findByProductId(Long productId);

    @Modifying
    @Query("update OrderItemEntity p " +
            "set p.quantity = p.quantity + :quantity " +
            "where p.orderId = :orderId " +
            "and p.productId = :productId")
    void increaseQuantity(Long orderId, Long productId, Long quantity);

    @Query("select sum(p.price * p.quantity)" +
            " from OrderItemEntity p " +
            "where p.orderId = :orderId")
    Long sumTotalPriceByOrderId(Long orderId);
}
