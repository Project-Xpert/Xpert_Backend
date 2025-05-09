package org.example.fx.mapper;

import lombok.RequiredArgsConstructor;
import org.example.GenericMapper;
import org.example.domain.fx.model.Fx;
import org.example.domain.user.model.User;
import org.example.fx.entity.FxJpaEntity;
import org.example.user.entity.UserJpaEntity;
import org.example.user.mapper.UserMapper;
import org.example.user.repository.UserJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FxMapper implements GenericMapper<Fx, FxJpaEntity> {
    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;

    @Override
    public Optional<Fx> toDomain(Optional<FxJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        FxJpaEntity fxEntity = entity.get();
        User user = userMapper.toDomain(Optional.of(fxEntity.getUser())).get();

        return Optional.of(Fx.builder()
                        .type(fxEntity.getType())
                        .user(user)
                        .amount(fxEntity.getAmount())
                        .sumOfBuy(fxEntity.getSumOfBuy())
                        .build()
        );
    }

    @Override
    public FxJpaEntity toEntity(Fx domain) {
        UserJpaEntity userEntity = userJpaRepository.findById(domain.getUser().getUserId()).get();

        return new FxJpaEntity(
                domain.getType(),
                userEntity,
                domain.getAmount(),
                domain.getSumOfBuy()
        );
    }
}
