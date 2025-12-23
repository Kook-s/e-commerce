    package io.commerce.user.infra.repository.impl;

    import io.commerce.common.snowflake.Snowflake;
    import io.commerce.user.domain.model.UserPoint;
    import io.commerce.user.domain.repository.UserPointRepository;
    import io.commerce.user.infra.entity.UserPointEntity;
    import io.commerce.user.infra.repository.UserPointJpaRepository;
    import io.commerce.user.support.error.UserPointException;
    import io.commerce.user.support.error.code.UserPointErrorCode;
    import lombok.RequiredArgsConstructor;
    import org.springframework.stereotype.Repository;

    import java.util.Optional;

    @Repository
    @RequiredArgsConstructor
    public class UserPointRepositoryImpl implements UserPointRepository {

        private final Snowflake snowflake = new Snowflake();
        private final UserPointJpaRepository pointRepository;

        @Override
        public Optional<UserPoint> findByUserId(String userId) {
            return pointRepository.findByUserId(userId).map(UserPointEntity::toUserPoint);
        }

        @Override
        public void create(UserPoint userPoint) {
            pointRepository.save(UserPointEntity.from(userPoint));
        }

        @Override
        public void increasePoint(String userId, long amount) {
            int updated = pointRepository.increase(userId, amount);

            if(updated == 0) {
                throw new UserPointException(UserPointErrorCode.POINT_NOT_FOUND);
            }
        }

        @Override
        public void decreasePoint(String userId, long amount) {
            int updated = pointRepository.decrease(userId, amount);

            if(updated == 0) {
                throw new UserPointException(UserPointErrorCode.POINT_NOT_FOUND);
            }
        }
    }
