package io.commerce.user.support.error;

import io.commerce.common.error.BusinessException;
import io.commerce.user.support.error.code.UserErrorCode;

public class UserException extends BusinessException {
    public UserException(UserErrorCode errorCode) {
        super(errorCode);
    }
}
