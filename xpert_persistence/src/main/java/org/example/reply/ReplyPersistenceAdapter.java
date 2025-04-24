package org.example.reply;

import lombok.RequiredArgsConstructor;
import org.example.domain.reply.model.Reply;
import org.example.domain.reply.spi.QueryReplyPort;
import org.example.reply.mapper.ReplyMapper;
import org.example.reply.repository.ReplyJpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReplyPersistenceAdapter implements QueryReplyPort {
    private final ReplyJpaRepository replyJpaRepository;
    private final ReplyMapper replyMapper;

    @Override
    public void saveReply(Reply reply) {
        replyJpaRepository.save(replyMapper.toEntity(reply));
    }
}
