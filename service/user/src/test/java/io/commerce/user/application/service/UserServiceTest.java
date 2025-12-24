package io.commerce.user.application.service;

import io.commerce.user.application.dto.UserResult;
import io.commerce.user.domain.model.User;
import io.commerce.user.domain.repository.UserRepository;
import io.commerce.user.support.error.code.UserErrorCode;
import io.commerce.user.support.error.UserException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

//    @Test
//    @DisplayName("ID로 사용자 조회")
//    void getUserById() {
//        // given
//        User user = User.builder()
//                .id(1L)
//                .email("test@test.com")
//                .name("test")
//                .build();
//
//        given(userRepository.findById(1L))
//                .willReturn(Optional.of(user));
//
//        // when
//        UserResult result = userService.getUser(1L);
//
//        // then
//        assertThat(result.getEmail()).isEqualTo("test@test.com");
//    }
//
//    @Test
//    @DisplayName("ID로 사용자 실패")
//    void getUserByIdNotFound() {
//        // given
//        given(userRepository.findById(1L))
//                .willReturn(Optional.empty());
//
//        // when & then
//        assertThatThrownBy(() -> userService.getUser(1L))
//                .isInstanceOf(UserException.class)
//                .hasMessage(UserErrorCode.USER_NOT_FOUND.getMessage());
//    }

    @Test
    @DisplayName("Email로 사용자 조회")
    void getUserByEmail() {
        // given
        User user = User.builder()
                .email("test@test.com")
                .name("test")
                .build();

        given(userRepository.findByEmail("test@test.com"))
                .willReturn(Optional.of(user));

        // when
        UserResult result = userService.getUser("test@test.com");

        // then
        assertThat(result.getEmail()).isEqualTo("test@test.com");
    }

    @Test
    @DisplayName("Email로 사용자 실패")
    void getUserByEmailNotFound() {
        // given
        given(userRepository.findByEmail("test@test.com"))
                .willReturn(Optional.empty());

        // when & then
        assertThatThrownBy(() -> userService.getUser("test@test.com"))
                .isInstanceOf(UserException.class)
                .hasMessage(UserErrorCode.USER_NOT_FOUND.getMessage());
    }

}