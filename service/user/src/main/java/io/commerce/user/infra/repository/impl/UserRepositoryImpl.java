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
    public void signup(User user) {
        userJpaRepository.save(UserEntity.from(user));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userJpaRepository.findByEmail(email).map(UserEntity::toUser);
    }
}
