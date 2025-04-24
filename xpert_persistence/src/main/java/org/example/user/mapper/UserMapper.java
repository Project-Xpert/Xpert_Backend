package org.example.user.mapper;

import org.example.GenericMapper;
import org.example.domain.user.model.User;
import org.example.user.entity.UserJpaEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserMapper implements GenericMapper<User, UserJpaEntity> {
    @Override
    public Optional<User> toDomain(Optional<UserJpaEntity> entity) {
        if (entity.isEmpty()) {
            return Optional.empty();
        }

        UserJpaEntity userEntity = entity.get();

        return Optional.of(User.builder()
                .userId(userEntity.getUserId())
                .email(userEntity.getEmail())
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .profile(userEntity.getProfile())
                .money(userEntity.getMoney())
                .build());
    }

    @Override
    public UserJpaEntity toEntity(User domain) {
        return new UserJpaEntity(
                domain.getUserId(),
                domain.getEmail(),
                domain.getUsername(),
                domain.getPassword(),
                domain.getProfile(),
                domain.getMoney()
        );
    }
}
