package io.commerce.product.support.error;

import io.commerce.common.error.BusinessException;
import io.commerce.product.support.error.code.ProductErrorCode;
import io.commerce.product.support.error.code.ProductStockErrorCode;

public class ProductStockException extends BusinessException {
    public ProductStockException(ProductStockErrorCode errorCode) {
        super(errorCode);
    }
}
