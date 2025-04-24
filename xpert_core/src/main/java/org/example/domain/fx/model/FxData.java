package org.example.domain.fx.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Builder
public class FxData {

    private LocalDate date;

    private FXType type;

    private int price;

    private int buyPrice;

    private int sellPrice;
}
