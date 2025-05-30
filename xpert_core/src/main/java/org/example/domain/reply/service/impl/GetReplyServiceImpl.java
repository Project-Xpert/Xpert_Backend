package org.example.domain.reply.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.reply.spi.vo.ReplyDataWithLikeCntVO;
import org.example.domain.reply.exception.ReplyNotFoundException;
import org.example.domain.reply.model.Reply;
import org.example.domain.reply.service.GetReplyService;
import org.example.domain.reply.spi.QueryReplyPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetReplyServiceImpl implements GetReplyService {
    private final QueryReplyPort queryReplyPort;

    @Override
    public Reply getReplyByReplyId(UUID replyId) {
        return queryReplyPort.findReplyByReplyId(replyId).orElseThrow(
                () -> ReplyNotFoundException.EXCEPTION
        );
    }

    @Override
    public List<ReplyDataWithLikeCntVO> getReplyStatusListByPostId(UUID postId) {
        return queryReplyPort.findReplyStatusListByPostId(postId);
    }
}
