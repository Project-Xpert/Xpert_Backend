package org.example.domain.fx.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.fx.exception.FXDataNotFoundException;
import org.example.domain.fx.model.FxType;
import org.example.domain.fx.model.FxData;
import org.example.domain.fx.service.GetFxDataService;
import org.example.domain.fx.spi.QueryFxDataPort;
import org.example.domain.fx.spi.vo.FxDataWithRangeVO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetFxDataServiceImpl implements GetFxDataService {
    private final QueryFxDataPort queryFxDataPort;

    @Override
    public FxData getFxDataByLocalDateAndFxType(LocalDate date, FxType fxType) {
        return queryFxDataPort.getFxDataByLocalDateAndFxType(date, fxType)
                .orElseThrow(() -> FXDataNotFoundException.EXCEPTION);
    }

    @Override
    public List<FxDataWithRangeVO> getNewestFxData() {
        return queryFxDataPort.getNewestFxData();
    }

    @Override
    public FxData getNewestFxDataByFxType(FxType fxType) {
        return queryFxDataPort.getNewestFxDataByFxType(fxType)
                .orElseThrow(() -> FXDataNotFoundException.EXCEPTION);
    }

    @Override
    public int getTodayDollarPrice() {
        return queryFxDataPort.getTodayDollarPrice();
    }
}
