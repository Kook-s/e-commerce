package io.commerce.order.application.service;

import io.commerce.common.snowflake.Snowflake;
import io.commerce.order.application.dto.CreateOrderItemCommand;
import io.commerce.order.domain.model.OrderItem;
import io.commerce.order.domain.repository.OrderItemRepository;
import io.commerce.order.support.config.SnowflakeConfig;
import io.commerce.order.support.error.OrderItemException;
import io.commerce.order.support.error.code.OrderItemErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final Snowflake snowflake;
    private final OrderItemRepository orderItemRepository;

    public void create(CreateOrderItemCommand command) {
        orderItemRepository.save(
                OrderItem.create(
                        snowflake.nextId(),
                        command.getOrderId(),
                        command.getProductId(),
                        command.getPrice(),
                        command.getQuantity()
                )
        );
    }

    public OrderItem getOrderItem(Long id) {
        return orderItemRepository.findById(id)
                .orElseThrow(() -> new OrderItemException(OrderItemErrorCode.ORDER_ITEM_NOT_FOUND));
    }

    public List<OrderItem> getOrderItemsByOrderId(Long orderId) {
        return orderItemRepository.findByOrderId(orderId);
    }

    public List<OrderItem> getOrderItemsByProductId(Long productId) {
        return orderItemRepository.findByProductId(productId);
    }


    public void addOrIncrease(CreateOrderItemCommand command) {
        orderItemRepository.findByOrderIdAndProductId(command.getOrderId(), command.getProductId())
                .ifPresentOrElse(
                        item -> {
                            item.increase(command.getQuantity());

                            orderItemRepository.increaseQuantity(
                                    command.getOrderId(),
                                    command.getProductId(),
                                    command.getQuantity()
                            );
                        },
                        () -> orderItemRepository.save(OrderItem.create(
                                snowflake.nextId(),
                                command.getOrderId(),
                                command.getProductId(),
                                command.getPrice(),
                                command.getQuantity()
                                )
                        )
                );
    }

    public long calculateTotalPrice(Long orderId) {
        Long totalPrice = orderItemRepository.sumTotalPriceByOrderId(orderId);
        return totalPrice == null ? 0 : totalPrice;
    }
}
