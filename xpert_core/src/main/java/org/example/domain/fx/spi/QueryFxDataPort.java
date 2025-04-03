package org.example.domain.fx.spi;

import org.example.domain.fx.model.FXType;
import org.example.domain.fx.model.FxData;

import java.time.LocalDate;
import java.util.Optional;

public interface QueryFxDataPort {

    void saveFxData(FxData fxData);

    void delete(FxData fxData);

    Optional<FxData> getFxDataByLocalDateAndFxType(LocalDate date, FXType fxType);
}
