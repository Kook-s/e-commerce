package io.commerce.product.support.error.code;

import io.commerce.common.error.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ProductStockErrorCode implements ErrorCode {

    PRODUCT_STOCK_NOT_FOUND("PRODUCT-STOCK-001", HttpStatus.NOT_FOUND, "상품 재고 정보를 찾을 수 없습니다."),
    PRODUCT_STOCK_INSUFFICIENT("PRODUCT-STOCK-002", HttpStatus.BAD_REQUEST, "상품 재고가 부족합니다."),
    PRODUCT_STOCK_ALREADY_INITIALIZED("PRODUCT-STOCK-003", HttpStatus.CONFLICT, "상품 재고가 이미 초기화되어 있습니다.");

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
