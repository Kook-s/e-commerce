package io.commerce.user.domain.repository;

import io.commerce.user.domain.model.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findById(Long id);
    Optional<User> findByEmail(Long email);
}
