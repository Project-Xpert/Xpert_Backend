package org.example.domain.reply.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.reply.exception.IsNotOwnerOfReplyException;
import org.example.domain.reply.model.Reply;
import org.example.domain.reply.service.CheckReplyService;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckReplyServiceImpl implements CheckReplyService {

    @Override
    public void userIsOwnerOfReply(User user, Reply reply) {
        if (!user.getUserId().equals(reply.getUser().getUserId())) {
            throw IsNotOwnerOfReplyException.EXCEPTION;
        }
    }
}
