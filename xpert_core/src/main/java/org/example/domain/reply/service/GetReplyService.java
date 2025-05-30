package org.example.domain.reply.service;

import org.example.domain.reply.spi.vo.ReplyDataWithLikeCntVO;
import org.example.domain.reply.model.Reply;

import java.util.List;
import java.util.UUID;

public interface GetReplyService {

    Reply getReplyByReplyId(UUID replyId);

    List<ReplyDataWithLikeCntVO> getReplyStatusListByPostId(UUID postId);
}
