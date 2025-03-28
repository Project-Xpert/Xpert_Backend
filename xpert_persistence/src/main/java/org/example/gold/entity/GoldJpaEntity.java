package org.example.gold.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.domain.gold.model.GoldType;
import org.example.user.entity.UserJpaEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Entity(name = "gold")
@IdClass(GoldId.class)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GoldJpaEntity {
    @Id
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private GoldType goldType;

    @Id
    @ManyToOne(targetEntity = UserJpaEntity.class, optional = false)
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserJpaEntity user;

    @Column(nullable = false, columnDefinition = "INT UNSIGNED")
    private int cnt;
}
