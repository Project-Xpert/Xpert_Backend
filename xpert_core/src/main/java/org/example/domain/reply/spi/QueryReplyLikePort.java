package org.example.domain.reply.spi;

import org.example.domain.reply.model.Reply;
import org.example.domain.reply.model.ReplyLike;
import org.example.domain.user.model.User;

import java.util.UUID;

public interface QueryReplyLikePort {

    void saveReplyLike(ReplyLike replyLike);

    void deleteReplyLike(ReplyLike replyLike);

    boolean existsByUserAndReply(User user, Reply reply);

    boolean existsByReplyIdAndUser(UUID replyId, User user);
}
