package org.example.stock.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.domain.stock.modal.StockCategory;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@DynamicInsert
@DynamicUpdate
@Entity(name = "stock")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StockJpaEntity {
    @Id
    @Column(columnDefinition = "CHAR(5)", nullable = false)
    private String stockCode;

    @Column(columnDefinition = "VARCHAR(30)", nullable = false)
    private String stockName;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("'OTHER'")
    @Column(nullable = false)
    private StockCategory category;

    // 토스에서 크롤링 해오기 위한 컬럼
    @Column(columnDefinition = "CHAR(13)", nullable = false, unique = true)
    private String tossStockCode;
}
