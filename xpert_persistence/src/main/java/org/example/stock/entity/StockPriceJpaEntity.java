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
    private String stockCode;

    @Id
    @Column(columnDefinition = "DATE", nullable = false)
    private LocalDate date;

    @Column(columnDefinition = "INTEGER", nullable = false)
    private int price;
}
