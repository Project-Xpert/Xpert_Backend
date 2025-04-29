package org.example.domain.reply.service;

import org.example.domain.reply.model.Reply;

import java.util.UUID;

public interface GetReplyService {

    Reply getReplyByReplyId(UUID replyId);
}
