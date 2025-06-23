package org.example.stock.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.domain.stock.modal.TradeType;
import org.example.user.entity.UserJpaEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.UUID;

@Getter
@Entity(name = "stock_order")
@DynamicInsert
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StockOrderJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID orderId;

    @ManyToOne(targetEntity = StockJpaEntity.class, optional = false)
    @JoinColumn(name = "stockCode", referencedColumnName = "stockCode", nullable = false)
    private StockJpaEntity stock;

    @ManyToOne(targetEntity = UserJpaEntity.class, optional = false)
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    private UserJpaEntity user;

    @Column(columnDefinition = "INTEGER", nullable = false)
    private int price;

    @Column(columnDefinition = "INTEGER", nullable = false)
    private int amount;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private TradeType tradeType;
}
