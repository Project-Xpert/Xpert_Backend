package org.example.domain.reply.service;

import org.example.domain.reply.model.Reply;
import org.example.domain.user.model.User;

public interface CheckReplyService {

    void userIsOwnerOfReply(User user, Reply reply);
}
