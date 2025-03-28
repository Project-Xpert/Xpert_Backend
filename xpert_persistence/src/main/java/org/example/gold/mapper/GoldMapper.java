package org.example.gold.mapper;

import lombok.RequiredArgsConstructor;
import org.example.GenericMapper;
import org.example.domain.gold.model.Gold;
import org.example.domain.user.exception.UserNotFoundException;
import org.example.gold.entity.GoldJpaEntity;
import org.example.user.entity.UserJpaEntity;
import org.example.user.repository.UserJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GoldMapper implements GenericMapper<Gold, GoldJpaEntity> {
    private final UserJpaRepository userJpaRepository;

    @Override
    public Optional<Gold> toDomain(Optional<GoldJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        GoldJpaEntity goldEntity = entity.get();

        return Optional.of(Gold.builder()
                .goldType(goldEntity.getGoldType())
                .userId(goldEntity.getUser().getUserId())
                .cnt(goldEntity.getCnt())
                .build()
        );
    }

    @Override
    public GoldJpaEntity toEntity(Gold domain) {
        UserJpaEntity userJpaEntity = userJpaRepository.findById(domain.userId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        return new GoldJpaEntity(
                domain.goldType(),
                userJpaEntity,
                domain.cnt()
        );
    }
}
