package org.example.fx.entity;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.domain.fx.model.FxType;

import java.io.Serializable;
import java.time.LocalDate;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class FxDataId implements Serializable {
    private LocalDate date;
    private FxType type;
}
