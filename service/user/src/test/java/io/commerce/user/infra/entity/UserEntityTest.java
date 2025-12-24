package io.commerce.user.infra.entity;

import io.commerce.user.domain.UserStatus;
import io.commerce.user.domain.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserEntityTest {

    @Test
    void userToEntity() {
        User user = User.builder()
                .id(1L)
                .email("test@test.com")
                .password("qwe123")
                .name("userA")
                .status(UserStatus.USER)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        UserEntity entity = UserEntity.from(user);

        assertThat(entity.getId()).isEqualTo(user.getId());
        assertThat(entity.getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    void entityToUser() {
        UserEntity entity = UserEntity.from(
                User.builder()
                        .id(1L)
                        .email("test@test.com")
                        .password("qwe123")
                        .name("userA")
                        .status(UserStatus.USER)
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build()
        );

        User user = entity.toUser();
        assertThat(user.getId()).isEqualTo(entity.getId());
        assertThat(user.getEmail()).isEqualTo(entity.getEmail());
    }
}