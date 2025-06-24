package org.example.domain.stock.dto.request;

import org.example.domain.stock.dto.vo.StockTradeOption;

public record SellStockRequestDto(
    StockTradeOption option,

    String stockCode,

    int price,

    int amount
) {
}
