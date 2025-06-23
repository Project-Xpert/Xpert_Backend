package org.example.stock.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.user.entity.UserJpaEntity;

import java.io.Serializable;
import java.time.LocalDate;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class StockHoldingId implements Serializable {

    private UserJpaEntity user;

    private StockJpaEntity stock;
}
