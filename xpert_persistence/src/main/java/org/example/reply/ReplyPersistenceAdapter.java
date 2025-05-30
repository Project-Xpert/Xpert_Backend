package org.example.reply;

import lombok.RequiredArgsConstructor;
import org.example.domain.reply.spi.vo.ReplyDataWithLikeCntVO;
import org.example.domain.reply.model.Reply;
import org.example.domain.reply.spi.QueryReplyPort;
import org.example.reply.mapper.ReplyMapper;
import org.example.reply.repository.ReplyJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ReplyPersistenceAdapter implements QueryReplyPort {
    private final ReplyJpaRepository replyJpaRepository;
    private final ReplyMapper replyMapper;

    @Override
    public void saveReply(Reply reply) {
        replyJpaRepository.save(replyMapper.toEntity(reply));
    }

    @Override
    public Optional<Reply> findReplyByReplyId(UUID replyId) {
        return replyMapper.toDomain(replyJpaRepository.findById(replyId));
    }

    @Override
    public void deleteReply(Reply reply) {
        replyJpaRepository.delete(replyMapper.toEntity(reply));
    }

    @Override
    public List<ReplyDataWithLikeCntVO> findReplyStatusListByPostId(UUID postId) {
        return replyJpaRepository.getReplyStatusListByPostId(postId);
    }
}
