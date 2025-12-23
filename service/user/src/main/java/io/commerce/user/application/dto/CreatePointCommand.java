package io.commerce.user.application.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreatePointCommand {
    private String userId;

}
