package org.example.post.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.user.entity.UserJpaEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Entity(name = "post_like")
@IdClass(LikeId.class)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostLikeJpaEntity {
    @Id
    @ManyToOne(targetEntity = UserJpaEntity.class, optional = false)
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserJpaEntity user;

    @Id
    @ManyToOne(targetEntity = PostJpaEntity.class, optional = false)
    @JoinColumn(name = "postId", referencedColumnName = "postId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PostJpaEntity post;
}
