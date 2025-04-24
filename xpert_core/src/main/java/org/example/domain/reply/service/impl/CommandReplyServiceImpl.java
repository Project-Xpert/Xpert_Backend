package org.example.domain.reply.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.reply.model.Reply;
import org.example.domain.reply.service.CommandReplyService;
import org.example.domain.reply.spi.QueryReplyPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandReplyServiceImpl implements CommandReplyService {
    private final QueryReplyPort queryReplyPort;

    @Override
    public void saveReply(Reply reply) {
        queryReplyPort.saveReply(reply);
    }
}
