package io.commerce.user.domain.model;

import io.commerce.user.support.error.UserPointException;
import io.commerce.user.support.error.code.UserPointErrorCode;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserPoint {
    private final Long id;
    private final Long userId;
    private Long balance;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserPoint(Long id, Long userId, Long balance, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.userId = userId;
        this.balance = balance;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static UserPoint create(Long id, Long userId) {
        return new UserPoint(
                id,
                userId,
                0L,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    public void increase(Long amount) {
        if (amount == null || amount <= 0) {
            throw new UserPointException(UserPointErrorCode.INVALID_POINT_AMOUNT);
        }

        this.balance += amount;
        this.updatedAt = LocalDateTime.now();
    }

    public void decrease(Long amount) {
        if (amount == null || amount <= 0) {
            throw new UserPointException(UserPointErrorCode.INVALID_POINT_AMOUNT);
        }
        if(balance < amount) {
            throw new UserPointException(UserPointErrorCode.INSUFFICIENT_POINT);
        }
        this.balance -= amount;
        this.updatedAt = LocalDateTime.now();
    }
}
