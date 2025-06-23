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
}
