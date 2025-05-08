package org.example.domain.fx.usecase;

import lombok.RequiredArgsConstructor;
import org.example.domain.fx.dto.response.GetNewestFxDataResponseDto;
import org.example.domain.fx.service.GetFxDataService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetNewestFxDataUseCase {
    private final GetFxDataService getFxDataService;

    public GetNewestFxDataResponseDto execute() {
        return GetNewestFxDataResponseDto.from(getFxDataService.getNewestFxData());
    }
}
