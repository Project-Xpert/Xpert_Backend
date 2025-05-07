package org.example.domain.reply.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.reply.model.Reply;
import org.example.domain.reply.service.CheckReplyLikeService;
import org.example.domain.reply.spi.QueryReplyLikePort;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckReplyLikeServiceImpl implements CheckReplyLikeService {
    private final QueryReplyLikePort queryReplyLikePort;

    @Override
    public boolean getBooleanOfExistsByReplyAndUser(Reply reply, User user) {
        return queryReplyLikePort.checkReplyLikeByUserAndReply(user, reply);
    }
}
