package org.example.fxData.mapper;

import org.example.GenericMapper;
import org.example.domain.fx.model.FxData;
import org.example.fxData.entity.FxDataJpaEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FxDataMapper implements GenericMapper<FxData, FxDataJpaEntity> {

    @Override
    public Optional<FxData> toDomain(Optional<FxDataJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        FxDataJpaEntity jpaEntity = entity.get();

        return Optional.of(FxData.builder()
                .date(jpaEntity.getDate())
                .type(jpaEntity.getType())
                .price(jpaEntity.getPrice())
                .buyPrice(jpaEntity.getBuyPrice())
                .sellPrice(jpaEntity.getSellPrice())
                .build()
        );
    }

    @Override
    public FxDataJpaEntity toEntity(FxData domain) {
        return new FxDataJpaEntity(
                domain.date(),
                domain.type(),
                domain.price(),
                domain.sellPrice(),
                domain.buyPrice()
        );
    }
}
