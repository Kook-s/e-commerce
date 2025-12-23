package io.commerce.user.interfaces.controller;

import io.commerce.user.application.dto.UserResult;
import io.commerce.user.application.service.UserService;
import io.commerce.user.interfaces.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/id/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable("id") Long id) {
        UserResult user = userService.getUser(id);

        return ResponseEntity.ok(UserResponse.from(user));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserResponse> getUserByEmail(@PathVariable("email") String email) {
        UserResult user = userService.getUser(email);

        return ResponseEntity.ok(UserResponse.from(user));
    }
}
