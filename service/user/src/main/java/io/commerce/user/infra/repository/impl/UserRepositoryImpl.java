package io.commerce.user.infra.repository.impl;

import io.commerce.user.domain.model.User;
import io.commerce.user.domain.repository.UserRepository;
import io.commerce.user.infra.entity.UserEntity;
import io.commerce.user.infra.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public Optional<User> findById(Long id) {
        return userJpaRepository.findById(id).map(UserEntity::toUser);
    }

    @Override
    public Optional<User> findByEmail(Long email) {
        return Optional.empty();
    }
}
