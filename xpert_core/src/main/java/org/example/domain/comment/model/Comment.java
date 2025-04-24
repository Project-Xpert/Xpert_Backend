package org.example.domain.comment.model;

import lombok.Builder;
import org.example.domain.post.model.Post;
import org.example.domain.user.model.User;

import java.time.LocalDate;
import java.util.UUID;

@Builder
public record Comment(
    UUID commentId,
    User user,
    Post post,
    String content,
    LocalDate createAt
) {
}
