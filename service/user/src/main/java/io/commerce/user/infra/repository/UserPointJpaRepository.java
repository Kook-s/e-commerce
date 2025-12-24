package io.commerce.user.infra.repository;

import io.commerce.user.infra.entity.UserPointEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserPointJpaRepository extends JpaRepository<UserPointEntity, Long> {
    Optional<UserPointEntity> findByUserId(Long userId);

    @Modifying
    @Query("update UserPointEntity p " +
            "set p.balance = p.balance - :amount, " +
            " p.updatedAt = now() " +
            "where p.userId = :userId")
    int decrease(@Param("userId") Long userId, @Param("amount") long amount);

    @Modifying
    @Query("update UserPointEntity p " +
            "set p.balance = p.balance + :amount, " +
            " p.updatedAt = now() " +
            "where p.userId = :userId")
    int increase(@Param("userId") Long userId, @Param("amount") long amount);
}
