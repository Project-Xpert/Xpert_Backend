package org.example.domain.reply.service;

import org.example.domain.reply.model.ReplyLike;

public interface CommandReplyLikeService {

    void saveReplyLike(ReplyLike replyLike);

    void deleteReplyLike(ReplyLike replyLike);
}
