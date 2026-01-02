package io.commerce.order.application.service;

import io.commerce.common.snowflake.Snowflake;
import io.commerce.order.domain.OrderStatus;
import io.commerce.order.domain.model.Order;
import io.commerce.order.domain.repository.OrderRepository;
import io.commerce.order.support.config.SnowflakeConfig;
import io.commerce.order.support.error.OrderException;
import io.commerce.order.support.error.code.OrderErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final Snowflake snowflake;
    private final OrderRepository orderRepository;

    public void createOrder(Long userId) {
        orderRepository.save(Order.create(snowflake.nextId(), userId));
    }

    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderException(OrderErrorCode.ORDER_NOT_FOUND));
    }

    public List<Order> getOrderByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    public Order findBeforePaidByUser(Long userId) {
        return orderRepository.findByUserIdAndStatus(userId)
                .orElseGet(() -> orderRepository.save(Order.create(snowflake.nextId(), userId)));
    }

    public void updateTotalPrice(Long orderId, Long totalPrice) {
        orderRepository.updateTotalPrice(orderId, totalPrice);
    }
}
