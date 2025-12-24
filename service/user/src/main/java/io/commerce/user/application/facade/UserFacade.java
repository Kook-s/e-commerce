package io.commerce.user.application.facade;

import io.commerce.user.application.dto.CreatePointCommand;
import io.commerce.user.application.dto.CreateUserCommand;
import io.commerce.user.application.service.UserPointService;
import io.commerce.user.application.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {
    private  final UserService userService;
    private final UserPointService userPointService;

    @Transactional
    public void createUser(CreateUserCommand command) {
        Long userId = userService.create(command);
        userPointService.create(CreatePointCommand.builder().userId(userId).build());
    }
}
