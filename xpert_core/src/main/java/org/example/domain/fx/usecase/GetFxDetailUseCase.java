package org.example.domain.fx.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.fx.dto.response.GetFxDetailResponseDto;
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
public class GetFxDetailUseCase {
    private final GetFxService getFxService;
    private final GetFxDataService getFxDataService;
    private final CurrentUserProvider currentUserProvider;

    public GetFxDetailResponseDto execute(FxType fxType) {
        User user = currentUserProvider.getCurrentUser();

        OwnFxVO ownFxVO = getFxService.getFxOwnDataByUser(user);
        FxData fxData = getFxDataService.getNewestFxDataByFxType(fxType);

        return GetFxDetailResponseDto.of(ownFxVO, fxData);
    }
}
