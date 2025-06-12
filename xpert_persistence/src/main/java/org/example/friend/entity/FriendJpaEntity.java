package org.example.friend.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.user.entity.UserJpaEntity;
import org.hibernate.annotations.*;

@Getter
@DynamicInsert
@DynamicUpdate
@IdClass(FriendId.class)
@Entity(name = "friend")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FriendJpaEntity {
    @Id
    @JoinColumn(name = "requester", referencedColumnName = "userId", nullable = false)
    @ManyToOne(targetEntity = UserJpaEntity.class, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserJpaEntity requester;

    @Id
    @JoinColumn(name = "receiver", referencedColumnName = "userId", nullable = false)
    @ManyToOne(targetEntity = UserJpaEntity.class, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserJpaEntity receiver;

    @ColumnDefault("0")
    @Column(columnDefinition = "tinyInt", nullable = false)
    private Boolean isAccepted;
}
