package org.example.fx.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.domain.fx.model.FxType;
import org.example.user.entity.UserJpaEntity;

import java.io.Serializable;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class FxId implements Serializable {
    private FxType type;
    private UserJpaEntity user;
}
