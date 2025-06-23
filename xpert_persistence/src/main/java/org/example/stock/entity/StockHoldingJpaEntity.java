package org.example.stock.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.user.entity.UserJpaEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Entity(name = "stock_holding")
@IdClass(StockHoldingId.class)
@DynamicInsert
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StockHoldingJpaEntity {
    @Id
    @ManyToOne(targetEntity = StockJpaEntity.class, optional = false)
    @JoinColumn(name = "stockCode", referencedColumnName = "stockCode", nullable = false)
    private StockJpaEntity stock;

    @Id
    @ManyToOne(targetEntity = UserJpaEntity.class, optional = false)
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    private UserJpaEntity user;

    @Column(nullable = false, columnDefinition = "INTEGER")
    private int amount;

    @Column(nullable = false, columnDefinition = "INTEGER")
    private int sumOfBuy;
}
