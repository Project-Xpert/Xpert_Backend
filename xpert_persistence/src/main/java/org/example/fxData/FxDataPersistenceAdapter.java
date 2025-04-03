package org.example.fxData;

import lombok.RequiredArgsConstructor;
import org.example.domain.fx.model.FXType;
import org.example.domain.fx.model.FxData;
import org.example.domain.fx.spi.QueryFxDataPort;
import org.example.fxData.entity.FxDataId;
import org.example.fxData.mapper.FxDataMapper;
import org.example.fxData.repository.FxDataJpaRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FxDataPersistenceAdapter implements QueryFxDataPort {
    private final FxDataMapper fxDataMapper;
    private final FxDataJpaRepository fxDataJpaRepository;

    @Override
    public void saveFxData(FxData fxData) {
        fxDataJpaRepository.save(
                fxDataMapper.toEntity(fxData)
        );
    }

    @Override
    public void delete(FxData fxData) {
        fxDataJpaRepository.delete(
                fxDataMapper.toEntity(fxData)
        );
    }

    @Override
    public Optional<FxData> getFxDataByLocalDateAndFxType(LocalDate date, FXType fxType) {
        return fxDataMapper.toDomain(fxDataJpaRepository.findById(
                new FxDataId(date, fxType)
        ));
    }
}
