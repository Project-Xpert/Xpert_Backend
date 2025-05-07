package org.example.reply.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.user.entity.UserJpaEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@IdClass(ReplyLIkeId.class)
@Entity(name = "reply_like")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReplyLikeJpaEntity {
    @Id
    @ManyToOne(targetEntity = UserJpaEntity.class, optional = false)
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserJpaEntity user;

    @Id
    @ManyToOne(targetEntity = ReplyJpaEntity.class, optional = false)
    @JoinColumn(name = "replyId", referencedColumnName = "replyId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ReplyJpaEntity reply;
}
