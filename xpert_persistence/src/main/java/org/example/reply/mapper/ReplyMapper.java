package org.example.reply.mapper;

import lombok.RequiredArgsConstructor;
import org.example.GenericMapper;
import org.example.comment.entity.CommentJpaEntity;
import org.example.comment.mapper.CommentMapper;
import org.example.domain.comment.model.Comment;
import org.example.domain.reply.model.Reply;
import org.example.domain.user.model.User;
import org.example.reply.entity.ReplyJpaEntity;
import org.example.user.entity.UserJpaEntity;
import org.example.user.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ReplyMapper implements GenericMapper<Reply, ReplyJpaEntity> {
    private final UserMapper userMapper;
    private final CommentMapper commentMapper;

    @Override
    public Optional<Reply> toDomain(Optional<ReplyJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        ReplyJpaEntity replyEntity = entity.get();

        User user = userMapper.toDomain(Optional.of(replyEntity.getUser())).get();
        Comment comment = commentMapper.toDomain(Optional.of(replyEntity.getComment())).get();

        return Optional.of(Reply.builder()
                .replyId(replyEntity.getReplyId())
                .content(replyEntity.getContent())
                .createAt(replyEntity.getCreatedAt())
                .comment(comment)
                .user(user)
                .build()
        );
    }

    @Override
    public ReplyJpaEntity toEntity(Reply domain) {
        UserJpaEntity userEntity = userMapper.toEntity(domain.user());
        CommentJpaEntity commentEntity = commentMapper.toEntity(domain.comment());

        return new ReplyJpaEntity(
                domain.replyId(),
                userEntity,
                commentEntity,
                domain.content(),
                domain.createAt()
        );
    }
}
