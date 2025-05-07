package org.example.reply;

import lombok.RequiredArgsConstructor;
import org.example.comment.mapper.CommentMapper;
import org.example.domain.comment.model.Comment;
import org.example.domain.reply.model.Reply;
import org.example.domain.reply.spi.QueryReplyPort;
import org.example.reply.mapper.ReplyMapper;
import org.example.reply.repository.ReplyJpaRepository;
import org.springframework.stereotype.Component;

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
}
