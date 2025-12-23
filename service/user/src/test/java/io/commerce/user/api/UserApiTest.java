package io.commerce.user.api;

import io.commerce.user.interfaces.dto.UserResponse;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestClient;

public class UserApiTest {

    RestClient restClient = RestClient.create("http://localhost:8080");

    @Test
    void findUserById() {
        UserResponse user = restClient.get()
                .uri("/v1/users/id/{id}", 1L)
                .retrieve()
                .body(UserResponse.class);

        System.out.println(user);
    }

    @Test
    void findUserByEmail() {
        UserResponse user = restClient.get()
                .uri("/v1/users/email/{email}", "test@test.com")
                .retrieve()
                .body(UserResponse.class);

        System.out.println(user);
    }
}
