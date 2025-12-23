package io.commerce.user.domain.model;

import io.commerce.user.domain.UserStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class User {

    private final Long id;
    private final String email;
    private final String password;
    private String name;
    private UserStatus status;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public User(Long id, String email, String password, LocalDateTime createdAt, String name, UserStatus status, LocalDateTime updatedAt) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.name = name;
        this.status = status;
        this.updatedAt = updatedAt;
    }
}
