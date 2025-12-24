package io.commerce.user.domain.repository;

import io.commerce.user.domain.model.User;

import java.util.Optional;

public interface UserRepository {

    //    Optional<User> findById(String id);
    void signup(User user);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
