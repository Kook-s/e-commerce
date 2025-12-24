package io.commerce.user.domain.repository;

import io.commerce.user.domain.model.UserPoint;

import java.util.Optional;

public interface UserPointRepository {
    Optional<UserPoint> findByUserId(Long userId);
    void create(UserPoint userPoint);

    void increasePoint(Long userId, long amount);
    void decreasePoint(Long userId, long amount);
}
