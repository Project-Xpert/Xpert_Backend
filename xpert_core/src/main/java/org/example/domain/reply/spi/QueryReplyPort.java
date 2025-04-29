package org.example.domain.reply.spi;

import org.example.domain.reply.model.Reply;

import java.util.Optional;
import java.util.UUID;

public interface QueryReplyPort {

    void saveReply(Reply reply);

    Optional<Reply> findReplyByReplyId(UUID replyId);

    void deleteReply(Reply reply);
}
