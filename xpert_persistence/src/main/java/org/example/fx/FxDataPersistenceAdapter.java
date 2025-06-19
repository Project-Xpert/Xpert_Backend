package org.example.fx;

import lombok.RequiredArgsConstructor;
import org.example.domain.fx.model.FxType;
import org.example.domain.fx.model.FxData;
import org.example.domain.fx.spi.QueryFxDataPort;
import org.example.domain.fx.spi.vo.FxDataWithRangeVO;
import org.example.fx.entity.FxDataId;
import org.example.fx.mapper.FxDataMapper;
import org.example.fx.repository.FxDataJpaRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
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
    public Optional<FxData> getFxDataByLocalDateAndFxType(LocalDate date, FxType fxType) {
        return fxDataMapper.toDomain(fxDataJpaRepository.findById(
                new FxDataId(date, fxType)
        ));
    }

    @Override
    public List<FxDataWithRangeVO> getNewestFxData() {
        List<Object[]> results = fxDataJpaRepository.getNewestFxData();

        return results.stream()
                .map(FxDataWithRangeVO::from)
                .toList();
    }

    @Override
    public Optional<FxData> getNewestFxDataByFxType(FxType fxType) {
        return fxDataMapper.toDomain(
                fxDataJpaRepository.getNewestFxDataByFxType(fxType)
        );
    }

    @Override
    public int getTodayDollarPrice() {
        return fxDataJpaRepository.getTodayDollarPrice();
    }
}
