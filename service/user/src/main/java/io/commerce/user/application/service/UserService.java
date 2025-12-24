package io.commerce.user.application.service;

import io.commerce.common.snowflake.Snowflake;
import io.commerce.user.application.dto.CreateUserCommand;
import io.commerce.user.application.dto.UserResult;
import io.commerce.user.domain.model.User;
import io.commerce.user.domain.repository.UserRepository;
import io.commerce.user.support.error.code.UserErrorCode;
import io.commerce.user.support.error.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final Snowflake snowflake = new Snowflake();
    private final UserRepository userRepository;

    public Long create(CreateUserCommand command) {

        if(userRepository.existsByEmail(command.getEmail())) {
            throw new UserException(UserErrorCode.USER_ALREADY_EXISTS);
        }

        User user = User.create(
                snowflake.nextId(),
                command.getEmail(),
                command.getPassword(),
                command.getName()
        );
        userRepository.signup(user);

        return user.getId();
    }

    public UserResult getUser(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UserException(UserErrorCode.USER_NOT_FOUND));

        return UserResult.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .password(user.getPassword())
                .status(user.getStatus())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }

}
