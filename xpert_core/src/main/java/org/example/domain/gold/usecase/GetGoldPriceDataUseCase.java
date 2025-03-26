package org.example.domain.gold.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.openAPI.gold.GetGoldPriceService;
import org.example.domain.gold.dto.response.GetGoldPricesResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetGoldPriceDataUseCase {
    private final GetGoldPriceService getGoldPriceService;

    public GetGoldPricesResponseDto execute() {
        return getGoldPriceService.getGoldPriceData();
    }
}
