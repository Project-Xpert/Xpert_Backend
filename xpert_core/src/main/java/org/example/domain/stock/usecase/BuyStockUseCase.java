package org.example.domain.stock.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.stock.dto.request.BuyStockRequestDto;
import org.example.domain.stock.dto.vo.StockTradeOption;
import org.example.domain.stock.modal.StockHolding;
import org.example.domain.stock.modal.StockOrder;
import org.example.domain.stock.modal.TradeType;
import org.example.domain.stock.service.CommandStockHoldingService;
import org.example.domain.stock.service.CommandStockOrderService;
import org.example.domain.user.exception.RunOutOfMoneyException;
import org.example.domain.user.model.User;
import org.example.domain.user.service.CommandUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BuyStockUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final CommandUserService commandUserService;
    private final CommandStockHoldingService commandStockHoldingService;
    private final CommandStockOrderService commandStockOrderService;


    public void execute(BuyStockRequestDto request) {
        User user = currentUserProvider.getCurrentUser();

        int totalPrice = request.amount() * request.price();

        if (totalPrice > user.getMoney()) {
            throw RunOutOfMoneyException.EXCEPTION;
        }

        if (request.option() == StockTradeOption.MARKET_PRICE) {
            user.setMoney(user.getMoney() - totalPrice);
            commandUserService.saveUser(user);

            commandStockHoldingService.buyStock(StockHolding.builder()
                    .stockCode(request.stockCode())
                    .userId(user.getUserId())
                    .amount(request.amount())
                    .sumOfBuy(totalPrice)
                    .build());
        } else {
            commandStockOrderService.save(StockOrder.builder()
                    .stockCode(request.stockCode())
                    .userId(user.getUserId())
                    .price(request.price())
                    .amount(request.amount())
                    .tradeType(TradeType.BUY)
                    .build());
        }
    }
}
