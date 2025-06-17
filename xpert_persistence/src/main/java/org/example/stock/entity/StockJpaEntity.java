package org.example.stock.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
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
}
