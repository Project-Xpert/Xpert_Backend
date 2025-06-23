package org.example.domain.stock.modal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Stock {

    private String stockCode;

    private String stockName;

    private StockCategory category;

    private String summary;
}
