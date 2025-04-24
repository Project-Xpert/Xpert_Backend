package org.example.domain.reply.spi;

import org.example.domain.reply.model.Reply;

public interface QueryReplyPort {

    void saveReply(Reply reply);
}
