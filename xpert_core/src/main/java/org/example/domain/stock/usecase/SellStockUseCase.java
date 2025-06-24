package org.example.domain.stock.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.stock.dto.request.SellStockRequestDto;
import org.example.domain.stock.dto.vo.StockTradeOption;
import org.example.domain.stock.exception.NotEnoughStockException;
import org.example.domain.stock.modal.Stock;
import org.example.domain.stock.modal.StockHolding;
import org.example.domain.stock.modal.StockOrder;
import org.example.domain.stock.modal.TradeType;
import org.example.domain.stock.service.CommandStockHoldingService;
import org.example.domain.stock.service.CommandStockOrderService;
import org.example.domain.stock.service.GetStockHoldingService;
import org.example.domain.stock.service.GetStockService;
import org.example.domain.user.model.User;
import org.example.domain.user.service.CommandUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SellStockUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final CommandUserService commandUserService;
    private final GetStockHoldingService getStockHoldingService;
    private final CommandStockHoldingService commandStockHoldingService;
    private final CommandStockOrderService commandStockOrderService;

    public void execute(SellStockRequestDto request) {
        User user = currentUserProvider.getCurrentUser();
        StockHolding stockHolding = getStockHoldingService
                .getStockHoldingByUserIdAndStockCode(user.getUserId(), request.stockCode());

        if (request.amount() > stockHolding.getAmount()) {
            throw NotEnoughStockException.EXCEPTION;
        }

        if (request.option() == StockTradeOption.MARKET_PRICE) {
            user.setMoney(user.getMoney() + (long) request.price() * request.amount());
            commandUserService.saveUser(user);
            commandStockHoldingService.sellStock(stockHolding, request.amount());
        } else {
            commandStockOrderService.save(StockOrder.builder()
                    .userId(user.getUserId())
                    .stockCode(request.stockCode())
                    .amount(request.amount())
                    .price(request.price())
                    .tradeType(TradeType.SELL)
                    .build());
        }
    }
}
