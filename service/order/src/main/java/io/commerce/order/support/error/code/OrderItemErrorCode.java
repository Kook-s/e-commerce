package io.commerce.order.support.error.code;

import io.commerce.common.error.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum OrderItemErrorCode implements ErrorCode {
    ORDER_ITEM_NOT_FOUND("ORDER_ITEM-001", HttpStatus.NOT_FOUND, "주문을 찾을 수 없습니다."),
    ORDER_ALREADY_EXISTS("ORDER_ITEM-002", HttpStatus.NOT_FOUND, "이미 존재하는 주문입니다."),
    ORDER_INSUFFICIENT_QUANTITY("ORDER_ITEM-003", HttpStatus.BAD_REQUEST, "수량이 부족합니다.");


    private final String code;
    private final HttpStatus status;
    private final String message;


    @Override
    public String code() {
        return code;
    }

    @Override
    public HttpStatus status() {
        return status;
    }

    @Override
    public String message() {
        return message;
    }
}
