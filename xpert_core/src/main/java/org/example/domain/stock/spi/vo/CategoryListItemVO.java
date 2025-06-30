package org.example.domain.stock.spi.vo;

import org.example.domain.stock.modal.StockCategory;

public record CategoryListItemVO (
    StockCategory category,

    long sumOfPrice,

    double avgPercentChange,

    long stockCount,

    long riseCnt
) {
}
