package io.commerce.order.domain.repository;

import io.commerce.order.domain.model.OrderItem;

import java.util.List;
import java.util.Optional;

public interface OrderItemRepository {

    Optional<OrderItem> findById(Long id);
    List<OrderItem> findByOrderId(Long orderId);
    List<OrderItem> findByProductId(Long productId);

    void save(OrderItem orderItem);

    Optional<OrderItem> findByOrderIdAndProductId(Long orderId, Long productId);

    void increaseQuantity(Long orderId, Long productId, Long quantity);

    Long sumTotalPriceByOrderId(Long orderId);
}
