package org.example.domain.fx.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.fx.dto.response.GetFxTradeDataResponseDto;
import org.example.domain.fx.service.GetFxDataService;
import org.example.domain.fx.spi.vo.FxTradeDataVO;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetFxTradeDataUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final GetFxDataService getFxDataService;

    public GetFxTradeDataResponseDto execute() {
        User user = currentUserProvider.getCurrentUser();

        FxTradeDataVO fxTradeData = getFxDataService.getTradeFxData();

        return GetFxTradeDataResponseDto.of(user, fxTradeData);
    }
}
