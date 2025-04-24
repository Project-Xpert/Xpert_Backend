package org.example.comment.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.user.entity.UserJpaEntity;

@Getter
@IdClass(CommentLikeId.class)
@Entity(name = "commentLike")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentLikeJpaEntity {
    @Id
    @ManyToOne(targetEntity = CommentJpaEntity.class, optional = false)
    @JoinColumn(name = "commentId", referencedColumnName = "commentId", nullable = false)
    private CommentJpaEntity comment;

    @Id
    @ManyToOne(targetEntity = UserJpaEntity.class, optional = false)
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    private  UserJpaEntity user;
}
