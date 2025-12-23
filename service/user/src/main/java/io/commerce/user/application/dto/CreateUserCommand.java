package io.commerce.user.application.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateUserCommand {
    private String email;
    private String password;
    private String name;
}
