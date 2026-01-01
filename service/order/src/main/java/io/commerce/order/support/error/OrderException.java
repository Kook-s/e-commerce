package io.commerce.order.support.error;

import io.commerce.common.error.BusinessException;
import io.commerce.order.support.error.code.OrderErrorCode;

public class OrderException extends BusinessException {

    public OrderException(OrderErrorCode errorCode) {
        super(errorCode);
    }
}
