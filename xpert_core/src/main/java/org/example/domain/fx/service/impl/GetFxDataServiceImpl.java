package org.example.domain.fx.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.fx.exception.FXDataNotFoundException;
import org.example.domain.fx.model.FXType;
import org.example.domain.fx.model.FxData;
import org.example.domain.fx.service.GetFxDataService;
import org.example.domain.fx.spi.QueryFxDataPort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class GetFxDataServiceImpl implements GetFxDataService {
    private final QueryFxDataPort queryFxDataPort;

    @Override
    public FxData getFxDataByLocalDateAndFxType(LocalDate date, FXType fxType) {
        return queryFxDataPort.getFxDataByLocalDateAndFxType(date, fxType)
                .orElseThrow(() -> FXDataNotFoundException.EXCEPTION);
    }
}
