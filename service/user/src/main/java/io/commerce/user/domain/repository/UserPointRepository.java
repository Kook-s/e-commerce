package io.commerce.user.domain.repository;

import io.commerce.user.domain.model.UserPoint;

import java.util.Optional;

public interface UserPointRepository {
    Optional<UserPoint> findByUserId(String userId);
    void create(UserPoint userPoint);

    void increasePoint(String userId, long amount);
    void decreasePoint(String userId, long amount);
}
