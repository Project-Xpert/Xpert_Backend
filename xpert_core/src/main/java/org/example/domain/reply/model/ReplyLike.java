package org.example.domain.reply.model;

import lombok.Builder;
import org.example.domain.user.model.User;

@Builder
public record ReplyLike(
    Reply reply,
    User user
) {
}
