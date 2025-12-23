package io.commerce.user.support.error;

import io.commerce.common.error.BusinessException;

public class UserException extends BusinessException {
    public UserException(UserErrorCode errorCode) {
        super(errorCode);
    }
}
