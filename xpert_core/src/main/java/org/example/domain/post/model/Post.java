package org.example.domain.post.model;

import lombok.Builder;
import org.example.domain.user.model.User;

import java.time.LocalDate;
import java.util.UUID;

@Builder
public record Post (
    UUID postId,

    User user,

    String title,

    String content,

    String file,
    LocalDate createdAt
) {
}
