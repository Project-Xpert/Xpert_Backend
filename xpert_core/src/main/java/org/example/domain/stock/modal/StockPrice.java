package org.example.domain.stock.modal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class StockPrice {

    private Stock stock;

    private LocalDate date;

    private double price;

    private double priceChange;

    private double percentChange;
}
