package org.example.comment.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.user.entity.UserJpaEntity;

import java.io.Serializable;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class CommentLikeId implements Serializable {

    private CommentJpaEntity comment;

    private UserJpaEntity user;
}
