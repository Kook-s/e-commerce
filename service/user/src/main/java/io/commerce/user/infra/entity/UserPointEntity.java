package io.commerce.user.infra.entity;

import io.commerce.user.domain.model.UserPoint;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "user_point")
@Entity
@Getter
@RequiredArgsConstructor
public class UserPointEntity {

    @Id
    private Long id;
    private String userId;
    private Long balance;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static UserPointEntity from(UserPoint userPoint) {
        UserPointEntity entity = new UserPointEntity();
        entity.id = userPoint.getId();
        entity.userId = userPoint.getUserId();
        entity.balance = userPoint.getBalance();
        entity.createdAt = userPoint.getCreatedAt();
        entity.updatedAt = userPoint.getUpdatedAt();

        return entity;
    }

    public UserPoint toUserPoint() {
        return new UserPoint(id, userId, balance, createdAt, updatedAt);
    }

}
