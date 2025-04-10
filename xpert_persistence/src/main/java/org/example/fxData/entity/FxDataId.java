package org.example.fxData.entity;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.domain.fx.model.FXType;

import java.io.Serializable;
import java.time.LocalDate;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class FxDataId implements Serializable {
    private LocalDate date;
    private FXType type;
}
