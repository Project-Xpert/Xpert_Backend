package org.example.comment.mapper;

import lombok.RequiredArgsConstructor;
import org.example.GenericMapper;
import org.example.comment.entity.CommentJpaEntity;
import org.example.comment.entity.CommentLikeJpaEntity;
import org.example.domain.comment.model.Comment;
import org.example.domain.comment.model.CommentLike;
import org.example.domain.user.model.User;
import org.example.user.entity.UserJpaEntity;
import org.example.user.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CommentLikeMapper implements GenericMapper<CommentLike, CommentLikeJpaEntity> {
    private final CommentMapper commentMapper;
    private final UserMapper userMapper;

    @Override
    public Optional<CommentLike> toDomain(Optional<CommentLikeJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        CommentLikeJpaEntity commentLikeEntity = entity.get();

        User user = userMapper.toDomain(Optional.of(commentLikeEntity.getUser())).get();
        Comment comment = commentMapper.toDomain(Optional.of(commentLikeEntity.getComment())).get();

        return Optional.of(CommentLike.builder()
                .comment(comment)
                .user(user)
                .build()
        );
    }

    @Override
    public CommentLikeJpaEntity toEntity(CommentLike domain) {
        CommentJpaEntity commentEntity = commentMapper.toEntity(domain.comment());
        UserJpaEntity userEntity = userMapper.toEntity(domain.user());

        return new CommentLikeJpaEntity(commentEntity, userEntity);
    }
}
