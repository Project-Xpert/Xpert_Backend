package org.example.domain.stock.dto.request;

import org.example.domain.stock.dto.vo.StockTradeOption;

public record BuyStockRequestDto(
    StockTradeOption option,

    String stockCode,

    int price,

    int amount
) {
}
