package io.commerce.user.interfaces.dto;

import io.commerce.user.application.dto.UserPointResult;
import lombok.Getter;

@Getter
public class PointResponse {

    private Long balance;

    public static PointResponse from(UserPointResult point) {
        PointResponse response = new PointResponse();
        response.balance = point.getBalance();

        return response;
    }
}
