package io.commerce.user.interfaces.dto;

import io.commerce.user.application.dto.CreateUserCommand;
import lombok.Getter;

@Getter
public class CreateUserRequest {
    private String email;
    private String password;
    private String name;

    public CreateUserCommand toCommand() {
        return CreateUserCommand.builder()
                .email(email)
                .password(password)
                .name(name)
                .build();
    }
}
