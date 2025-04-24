package org.example.reply.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.user.entity.UserJpaEntity;

@Getter
@IdClass(ReplyLIkeId.class)
@Entity(name = "replyLike")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReplyLikeJpaEntity {
    @Id
    @ManyToOne(targetEntity = ReplyJpaEntity.class, optional = false)
    @JoinColumn(name = "replyId", referencedColumnName = "replyId", nullable = false)
    private ReplyJpaEntity reply;

    @Id
    @ManyToOne(targetEntity = UserJpaEntity.class, optional = false)
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    private UserJpaEntity user;
}
