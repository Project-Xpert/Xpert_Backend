package org.example.domain.fx.spi;

import org.example.domain.fx.model.FxType;
import org.example.domain.fx.model.FxData;
import org.example.domain.fx.spi.vo.FxDataWithRangeVO;
import org.example.domain.fx.spi.vo.FxDetailVO;
import org.example.domain.fx.spi.vo.FxTradeDataVO;
import org.example.domain.user.model.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface QueryFxDataPort {

    void saveFxData(FxData fxData);

    void delete(FxData fxData);

    Optional<FxData> getFxDataByLocalDateAndFxType(LocalDate date, FxType fxType);

    List<FxDataWithRangeVO> getNewestFxData();

    FxDetailVO getFxDetail(User user, FxType fxType);

    FxTradeDataVO getTradeData();
}
