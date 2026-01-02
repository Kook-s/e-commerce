package io.commerce.order.application.facade;

import io.commerce.order.application.dto.CreateOrderCommand;
import io.commerce.order.application.dto.CreateOrderItemCommand;
import io.commerce.order.application.service.OrderItemService;
import io.commerce.order.application.service.OrderService;
import io.commerce.order.domain.model.Order;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderFacade {

    private final OrderService orderService;
    private final OrderItemService orderItemService;

    @Transactional
    public void order(CreateOrderCommand command) {
        // 결재 대기중인 주문 없으면 생성
        Order findOrder = orderService.findBeforePaidByUser(command.getUserId());

        // 주문 상품 생성
        orderItemService.addOrIncrease(new CreateOrderItemCommand(findOrder.getId(), command.getProductId(), command.getPrice(), command.getQuantity()));

        // 주문 정보 수정
        long totalPrice = orderItemService.calculateTotalPrice(findOrder.getId());
        orderService.updateTotalPrice(findOrder.getId(), totalPrice);
    }

}
