package org.example.domain.fx.service;

import org.example.domain.fx.model.FXType;
import org.example.domain.fx.model.FxData;

import java.time.LocalDate;

public interface GetFxDataService {

    FxData getFxDataByLocalDateAndFxType(LocalDate date, FXType fxType);
}
