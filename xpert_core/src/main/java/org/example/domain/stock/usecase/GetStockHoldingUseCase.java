package org.example.domain.stock.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.stock.dto.response.GetStockHoldingResponseDto;
import org.example.domain.stock.modal.StockHolding;
import org.example.domain.stock.service.CheckStockHoldingService;
import org.example.domain.stock.service.GetStockHoldingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetStockHoldingUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final GetStockHoldingService getStockHoldingService;
    private final CheckStockHoldingService checkStockHoldingService;

    public GetStockHoldingResponseDto execute(String stockCode) {
        String userId = currentUserProvider.getCurrentUserId();

        if (checkStockHoldingService.getExistsByUserIdAndStockCode(userId, stockCode)) {
            StockHolding stockHolding = getStockHoldingService.getStockHoldingByUserIdAndStockCode(userId, stockCode);
            return new GetStockHoldingResponseDto(stockHolding.getAmount());
        }

        return new GetStockHoldingResponseDto(0);
    }
}
