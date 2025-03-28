package org.example.gold.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.domain.gold.model.GoldType;
import org.example.user.entity.UserJpaEntity;

import java.io.Serializable;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class GoldId implements Serializable {

    private GoldType goldType;

    private UserJpaEntity user;
}
