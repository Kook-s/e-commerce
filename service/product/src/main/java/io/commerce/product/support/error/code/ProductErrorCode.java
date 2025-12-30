package io.commerce.product.support.error.code;

import io.commerce.common.error.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ProductErrorCode implements ErrorCode {

    PRODUCT_NOT_FOUND("PRODUCT-001", HttpStatus.NOT_FOUND, "상품을 찾을 수 없습니다."),
    PRODUCT_ALREADY_EXISTS("PRODUCT-002", HttpStatus.CONFLICT, "이미 존재하는 상품입니다."),
    PRODUCT_NOT_AVAILABLE("PRODUCT-003", HttpStatus.BAD_REQUEST, "판매 중인 상품이 아닙니다.");

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
