package io.commerce.order.infra.entity;

import io.commerce.order.domain.model.Order;
import io.commerce.order.domain.model.OrderItem;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "order_item")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderItemEntity {
    @Id
    private Long id;
    private Long orderId;
    private Long productId;
    private Long price;
    private Long quantity;

    public static OrderItemEntity from(OrderItem item) {
        OrderItemEntity entity = new OrderItemEntity();
        entity.id = item.getId();
        entity.orderId = item.getOrderId();
        entity.productId = item.getProductId();
        entity.price = item.getPrice();
        entity.quantity = item.getQuantity();

        return entity;
    }

    public OrderItem toOrderItem() {
        return OrderItem.builder()
                .id(id)
                .orderId(orderId)
                .productId(productId)
                .price(price)
                .quantity(quantity)
                .build();
    }


}
