package org.example.reply;

import lombok.RequiredArgsConstructor;
import org.example.domain.reply.model.Reply;
import org.example.domain.reply.model.ReplyLike;
import org.example.domain.reply.spi.QueryReplyLikePort;
import org.example.domain.user.model.User;
import org.example.reply.entity.ReplyLIkeId;
import org.example.reply.mapper.ReplyLikeMapper;
import org.example.reply.mapper.ReplyMapper;
import org.example.reply.repository.ReplyLikeJpaRepository;
import org.example.user.mapper.UserMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReplyLikePersistenceAdapter implements QueryReplyLikePort {
    private final ReplyLikeJpaRepository replyLikeJpaRepository;
    private final ReplyLikeMapper replyLikeMapper;
    private final UserMapper userMapper;
    private final ReplyMapper replyMapper;

    @Override
    public void saveReplyLike(ReplyLike replyLike) {
        replyLikeJpaRepository.save(replyLikeMapper.toEntity(replyLike));
    }

    @Override
    public void deleteReplyLike(ReplyLike replyLike) {
        replyLikeJpaRepository.delete(replyLikeMapper.toEntity(replyLike));
    }

    @Override
    public boolean checkReplyLikeByUserAndReply(User user, Reply reply) {
        return replyLikeJpaRepository.existsById(new ReplyLIkeId(
                replyMapper.toEntity(reply),
                userMapper.toEntity(user)
        ));
    }
}
