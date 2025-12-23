package io.commerce.user.infra.entity;

import io.commerce.user.domain.UserStatus;
import io.commerce.user.domain.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "users")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {

    @Id
    private Long id;
    private String email;
    private String password;
    private String name;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static UserEntity from(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.id = user.getId();
        userEntity.email = user.getEmail();
        userEntity.password = user.getPassword();
        userEntity.name = user.getName();
        userEntity.status = user.getStatus();
        userEntity.createdAt = user.getCreatedAt();
        userEntity.updatedAt = user.getUpdatedAt();
        return userEntity;
    }

    public User toUser() {
        return User.builder()
                .id(id)
                .email(email)
                .password(password)
                .name(name)
                .status(status)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}
