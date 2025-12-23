package io.commerce.user.support.error.code;

import io.commerce.common.error.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum UserPointErrorCode implements ErrorCode {

    POINT_NOT_FOUND("POINT-001", HttpStatus.NOT_FOUND, "포인트 정보를 찾을 수 없습니다."),
    INSUFFICIENT_POINT("POINT-002", HttpStatus.BAD_REQUEST, "포인트가 부족합니다."),
    INVALID_POINT_AMOUNT("POINT-003", HttpStatus.BAD_REQUEST, "유효하지 않은 포인트 금액입니다."),
    POINT_CANNOT_BE_USED("POINT-004", HttpStatus.FORBIDDEN, "포인트를 사용할 수 없는 상태입니다.");

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
