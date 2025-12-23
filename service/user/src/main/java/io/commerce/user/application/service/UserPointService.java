package io.commerce.user.application.service;

import io.commerce.common.snowflake.Snowflake;
import io.commerce.user.application.dto.CreatePointCommand;
import io.commerce.user.application.dto.CreateUserCommand;
import io.commerce.user.application.dto.UserPointResult;
import io.commerce.user.domain.model.UserPoint;
import io.commerce.user.domain.repository.UserPointRepository;
import io.commerce.user.support.error.UserPointException;
import io.commerce.user.support.error.code.UserPointErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class UserPointService {

    private final Snowflake snowflake = new Snowflake();
    private final UserPointRepository userPointRepository;

    public UserPointResult getUserPoint(String userId) {
        UserPoint userPoint = userPointRepository.findByUserId(userId).orElseThrow(() -> new UserPointException(UserPointErrorCode.POINT_NOT_FOUND));
        return UserPointResult.builder()
                .id(userPoint.getId())
                .userId(userPoint.getUserId())
                .balance(userPoint.getBalance())
                .createdAt(userPoint.getCreatedAt())
                .updatedAt(userPoint.getUpdatedAt())
                .build();
    }

    public void create(CreatePointCommand command) {
        UserPoint userPoint = UserPoint.create(
                snowflake.nextId(),
                command.getUserId()
        );

        userPointRepository.create(userPoint);
    }

    public void increaseBalance(String userId, Long amount) {
        UserPoint userPoint = userPointRepository.findByUserId(userId).orElseThrow(() -> new UserPointException(UserPointErrorCode.POINT_NOT_FOUND));
        userPoint.increase(amount);

        userPointRepository.increasePoint(userId, amount);
    }

    public void decreaseBalance(String userId, Long amount) {
        UserPoint userPoint = userPointRepository.findByUserId(userId).orElseThrow(() -> new UserPointException(UserPointErrorCode.POINT_NOT_FOUND));
        userPoint.decrease(amount);

        userPointRepository.decreasePoint(userId, amount);
    }


}
