package org.example.domain.reply.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.reply.model.ReplyLike;
import org.example.domain.reply.service.CommandReplyLikeService;
import org.example.domain.reply.spi.QueryReplyLikePort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandReplyLikeServiceImpl implements CommandReplyLikeService {
    private final QueryReplyLikePort queryReplyLikePort;

    @Override
    public void saveReplyLike(ReplyLike replyLike) {
        queryReplyLikePort.saveReplyLike(replyLike);
    }

    @Override
    public void deleteReplyLike(ReplyLike replyLike) {
        queryReplyLikePort.deleteReplyLike(replyLike);
    }
}
