package org.example.domain.comment.spi.vo;

import org.example.domain.comment.model.Comment;

import java.time.LocalDate;
import java.util.UUID;

public record CommentDataWithLikeCntVO(
    UUID commentId,
    String userId,
    String username,
    String profile,
    String content,
    LocalDate createdAt,
    Long likeCnt
) {
}
