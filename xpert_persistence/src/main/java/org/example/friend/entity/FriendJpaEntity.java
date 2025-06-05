package org.example.friend.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.user.entity.UserJpaEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@DynamicInsert
@DynamicUpdate
@IdClass(FriendId.class)
@Entity(name = "friend")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FriendJpaEntity {
    @Id
    @JoinColumn(name = "user1", referencedColumnName = "userId", nullable = false)
    @ManyToOne(targetEntity = UserJpaEntity.class, optional = false)
    private UserJpaEntity user1;

    @Id
    @JoinColumn(name = "user2", referencedColumnName = "userId", nullable = false)
    @ManyToOne(targetEntity = UserJpaEntity.class, optional = false)
    private UserJpaEntity user2;
}
