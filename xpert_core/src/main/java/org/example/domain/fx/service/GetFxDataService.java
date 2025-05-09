package org.example.domain.fx.service;

import org.example.domain.fx.model.FxType;
import org.example.domain.fx.model.FxData;
import org.example.domain.fx.spi.vo.FxDataWithRangeVO;
import org.example.domain.fx.spi.vo.FxDetailVO;
import org.example.domain.user.model.User;

import java.time.LocalDate;
import java.util.List;

public interface GetFxDataService {

    FxData getFxDataByLocalDateAndFxType(LocalDate date, FxType fxType);

    List<FxDataWithRangeVO> getNewestFxData();

    FxDetailVO getFxDataDetail(User user, FxType fxType);
}
