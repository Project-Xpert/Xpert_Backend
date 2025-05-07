package org.example.fx.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.domain.fx.model.FXType;
import org.example.user.entity.UserJpaEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@DynamicInsert
@IdClass(FxId.class)
@Entity(name = "fx")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FxJpaEntity {
    @Id
    @Column(nullable = false)
    private FXType fxType;

    @Id
    @ManyToOne(targetEntity = UserJpaEntity.class, optional = false)
    @JoinColumn(name = "user", referencedColumnName = "userId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserJpaEntity user;

    @Column(nullable = false, columnDefinition = "INTEGER")
    private int amount;

    @Column(nullable = false, columnDefinition = "INTEGER")
    private int sumOfBuy;
}
