package org.example.stock.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@EqualsAndHashCode
public class StockPriceId implements Serializable {

    private LocalDate date;

    private StockJpaEntity stock;
}
