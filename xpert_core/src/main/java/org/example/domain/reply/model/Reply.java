package org.example.domain.reply.model;

import lombok.Builder;
import org.example.domain.comment.model.Comment;
import org.example.domain.user.model.User;

import java.time.LocalDate;
import java.util.UUID;

@Builder
public record Reply(
    UUID replyId,
    User user,
    Comment comment,
    String content,
    LocalDate createAt
) {
}
