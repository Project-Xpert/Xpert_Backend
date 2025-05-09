package org.example.domain.fx.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.fx.dto.response.GetFxTradeDataResponseDto;
import org.example.domain.fx.model.Fx;
import org.example.domain.fx.model.FxData;
import org.example.domain.fx.model.FxType;
import org.example.domain.fx.service.GetFxDataService;
import org.example.domain.fx.service.GetFxService;
import org.example.domain.fx.spi.vo.OwnFxVO;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetFxTradeDataUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final GetFxDataService getFxDataService;
    private final GetFxService getFxService;

    public GetFxTradeDataResponseDto execute(FxType fxType) {
        User user = currentUserProvider.getCurrentUser();

        FxData fxData = getFxDataService.getNewestFxDataByFxType(fxType);
        OwnFxVO ownedFx = getFxService.getFxOwnDataByUserAndFxType(user, fxType);

        return GetFxTradeDataResponseDto.of(user, ownedFx, fxData);
    }
}
