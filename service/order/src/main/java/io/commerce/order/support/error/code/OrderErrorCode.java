package io.commerce.order.support.error.code;

import io.commerce.common.error.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum OrderErrorCode implements ErrorCode {
    ORDER_NOT_FOUND("ORDER-001", HttpStatus.NOT_FOUND, "주문을 찾을 수 없습니다."),
    ORDER_ALREADY_EXISTS("ORDER-002", HttpStatus.NOT_FOUND, "이미 존재하는 주문입니다.");


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
