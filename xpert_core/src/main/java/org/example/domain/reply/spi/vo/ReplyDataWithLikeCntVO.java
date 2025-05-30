package org.example.domain.reply.spi.vo;

import org.example.domain.reply.model.Reply;

import java.time.LocalDate;
import java.util.UUID;

public record ReplyDataWithLikeCntVO(
    UUID commentId,
    UUID replyId,
    String userId,
    String username,
    String profile,
    String content,
    LocalDate createdAt,
    Long likeCnt
) {
}
