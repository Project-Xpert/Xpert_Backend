package org.example.domain.fx.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.fx.dto.response.GetFxDetailResponseDto;
import org.example.domain.fx.model.FxType;
import org.example.domain.fx.service.GetFxDataService;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetFxDetailUseCase {
    private final GetFxDataService getFxDataService;
    private final CurrentUserProvider currentUserProvider;

    public GetFxDetailResponseDto execute(FxType fxType) {
        User user = currentUserProvider.getCurrentUser();

        return GetFxDetailResponseDto.from(
                getFxDataService.getFxDataDetail(user, fxType)
        );
    }
}
