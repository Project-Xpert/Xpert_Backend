package org.example.reply.mapper;

import lombok.RequiredArgsConstructor;
import org.example.GenericMapper;
import org.example.domain.reply.model.Reply;
import org.example.domain.reply.model.ReplyLike;
import org.example.domain.user.model.User;
import org.example.reply.entity.ReplyJpaEntity;
import org.example.reply.entity.ReplyLikeJpaEntity;
import org.example.user.entity.UserJpaEntity;
import org.example.user.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ReplyLikeMapper implements GenericMapper<ReplyLike, ReplyLikeJpaEntity> {
    private final ReplyMapper replyMapper;
    private final UserMapper userMapper;

    @Override
    public Optional<ReplyLike> toDomain(Optional<ReplyLikeJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        ReplyLikeJpaEntity replyLikeEntity = entity.get();

        Reply reply = replyMapper.toDomain(Optional.of(replyLikeEntity.getReply())).get();
        User user = userMapper.toDomain(Optional.of(replyLikeEntity.getUser())).get();

        return Optional.of(ReplyLike.builder()
                .reply(reply)
                .user(user)
                .build()
        );
    }

    @Override
    public ReplyLikeJpaEntity toEntity(ReplyLike domain) {
        ReplyJpaEntity replyEntity = replyMapper.toEntity(domain.getReply());
        UserJpaEntity userEntity = userMapper.toEntity(domain.getUser());

        return new ReplyLikeJpaEntity(replyEntity, userEntity);
    }
}
