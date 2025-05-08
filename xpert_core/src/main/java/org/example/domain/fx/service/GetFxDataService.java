package org.example.domain.fx.service;

import org.example.domain.fx.model.FXType;
import org.example.domain.fx.model.FxData;
import org.example.domain.fx.spi.vo.FxDataWithRangeVO;

import java.time.LocalDate;
import java.util.List;

public interface GetFxDataService {

    FxData getFxDataByLocalDateAndFxType(LocalDate date, FXType fxType);

    List<FxDataWithRangeVO> getNewestFxData();
}
