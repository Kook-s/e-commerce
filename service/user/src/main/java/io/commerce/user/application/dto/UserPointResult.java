package io.commerce.user.application.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class UserPointResult {

    private Long id;
    private String userId;
    private Long balance;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
