
package io.commerce.user.support.error;

import io.commerce.common.error.BusinessException;
import io.commerce.user.support.error.code.UserErrorCode;
import io.commerce.user.support.error.code.UserPointErrorCode;

public class UserPointException extends BusinessException {
    public UserPointException(UserPointErrorCode errorCode) {
        super(errorCode);
    }
}
