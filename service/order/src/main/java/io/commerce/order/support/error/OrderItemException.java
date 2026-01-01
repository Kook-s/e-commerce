package io.commerce.order.support.error;

import io.commerce.common.error.BusinessException;
import io.commerce.order.support.error.code.OrderItemErrorCode;


public class OrderItemException extends BusinessException {

    public OrderItemException(OrderItemErrorCode errorCode) {
        super(errorCode);
    }
}
