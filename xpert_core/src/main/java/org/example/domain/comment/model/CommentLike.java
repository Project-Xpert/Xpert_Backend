package org.example.domain.comment.model;

import lombok.Builder;
import org.example.domain.user.model.User;

@Builder
public record CommentLike(
    Comment comment,
    User user
) {
}
