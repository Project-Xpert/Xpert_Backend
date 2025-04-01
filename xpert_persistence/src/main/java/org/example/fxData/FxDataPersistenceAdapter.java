package org.example.fxData;

import lombok.RequiredArgsConstructor;
import org.example.domain.fx.model.FxData;
import org.example.domain.fx.spi.QueryFxDataPort;
import org.example.fxData.mapper.FxDataMapper;
import org.example.fxData.repository.FxDataJpaRepository;
import org.springframework.stereotype.Component;

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
}
