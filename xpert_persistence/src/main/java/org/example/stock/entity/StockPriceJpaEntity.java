package org.example.stock.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Getter
@DynamicInsert
@DynamicUpdate
@IdClass(StockPriceId.class)
@Entity(name = "stockPrice")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StockPriceJpaEntity {
    @Id
    @ManyToOne(targetEntity = StockJpaEntity.class, optional = false)
    @JoinColumn(name = "stockCode", referencedColumnName = "stockCode", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private StockJpaEntity stock;

    @Id
    @Column(columnDefinition = "DATE", nullable = false)
    private LocalDate date;

    @Column(columnDefinition = "DOUBLE", nullable = false)
    private double price;

    @Column(columnDefinition = "DOUBLE", nullable = false)
    private double priceChange;

    @Column(columnDefinition = "DOUBLE", nullable = false)
    private double percentChange;
}
