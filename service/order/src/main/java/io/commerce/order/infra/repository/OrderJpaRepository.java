package io.commerce.order.infra.repository;

import io.commerce.order.domain.OrderStatus;
import io.commerce.order.domain.model.Order;
import io.commerce.order.infra.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {

    List<OrderEntity> findByUserId(Long userId);

    Optional<OrderEntity> findByUserIdAndStatus(Long userId, OrderStatus status);
    boolean existsByUserIdAndStatus(Long userId, OrderStatus status);

    @Modifying
    @Query("update OrderEntity o " +
            "set o.totalPrice = o.totalPrice + :totalPrice " +
            "where o.id = :orderId ")
    void updateTotalPrice(Long orderId, Long totalPrice);
}
