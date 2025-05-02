package org.example.domain.reply.service;

import org.example.domain.comment.model.Comment;
import org.example.domain.reply.model.Reply;

import java.util.UUID;

public interface GetReplyService {

    Reply getReplyByReplyId(UUID replyId);

    int getCountByComment(Comment comment);
}
