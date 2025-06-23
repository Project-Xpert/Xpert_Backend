package org.example.domain.stock.modal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StockHolding {

    private String stockCode;

    private String userId;

    private int amount;

    private int sumOfBuy;

    public StockHolding marge(StockHolding stockHolding) {
        return StockHolding.builder()
                .stockCode(this.stockCode)
                .userId(this.userId)
                .amount(this.amount + stockHolding.getAmount())
                .sumOfBuy(this.sumOfBuy + stockHolding.getSumOfBuy())
                .build();
    }
}
