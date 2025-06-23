package org.example.domain.stock.modal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class StockOrder {
    private UUID orderId;

    private String stockCode;

    private String userId;

    private int price;

    private TradeType tradeType;
}
