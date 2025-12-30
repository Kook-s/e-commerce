package io.commerce.product.support.error;

import io.commerce.common.error.BusinessException;
import io.commerce.product.support.error.code.ProductErrorCode;

public class ProductException extends BusinessException {
    public ProductException(ProductErrorCode errorCode) {
        super(errorCode);
    }
}
