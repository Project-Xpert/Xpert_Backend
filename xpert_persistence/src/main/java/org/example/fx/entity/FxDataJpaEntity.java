package org.example.fx.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.fx.model.FXType;

import java.time.LocalDate;

@Getter
@Entity(name = "fx_data")
@IdClass(FxDataId.class)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FxDataJpaEntity {
    @Id
    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FXType type;

    @Column(nullable = false, columnDefinition = "INT UNSIGNED")
    private int price;

    @Column(nullable = false, columnDefinition = "INT UNSIGNED")
    private int sellPrice;

    @Column(nullable = false, columnDefinition = "INT UNSIGNED")
    private int buyPrice;
}
