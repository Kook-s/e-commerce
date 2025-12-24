package io.commerce.user.interfaces.dto;


import io.commerce.user.application.dto.UserResult;
import io.commerce.user.domain.UserStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
public class UserResponse {
    private Long id;
    private String email;
    private String name;
    private UserStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static UserResponse from(UserResult user) {
        UserResponse response = new UserResponse();

        response.id = user.getId();
        response.email = user.getEmail();
        response.name = user.getName();
        response.status = user.getStatus();
        response.createdAt = user.getCreatedAt();
        response.updatedAt = user.getUpdatedAt();

        return response;
    }


}
