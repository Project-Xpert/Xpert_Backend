package org.example.comment.mapper;

import lombok.RequiredArgsConstructor;
import org.example.GenericMapper;
import org.example.comment.entity.CommentJpaEntity;
import org.example.domain.comment.model.Comment;
import org.example.domain.post.model.Post;
import org.example.domain.user.model.User;
import org.example.post.entity.PostJpaEntity;
import org.example.post.mapper.PostMapper;
import org.example.user.entity.UserJpaEntity;
import org.example.user.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CommentMapper implements GenericMapper<Comment, CommentJpaEntity> {
    private final UserMapper userMapper;
    private final PostMapper postMapper;

    @Override
    public Optional<Comment> toDomain(Optional<CommentJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        CommentJpaEntity commentEntity = entity.get();

        User user = userMapper.toDomain(Optional.of(commentEntity.getUser())).get();
        Post post = postMapper.toDomain(Optional.of(commentEntity.getPost())).get();

        return Optional.of(Comment.builder()
                .commentId(commentEntity.getCommentId())
                .content(commentEntity.getContent())
                .createAt(commentEntity.getCreatedAt())
                .user(user)
                .post(post)
                .build()
        );
    }

    @Override
    public CommentJpaEntity toEntity(Comment domain) {
        UserJpaEntity userEntity = userMapper.toEntity(domain.getUser());
        PostJpaEntity postEntity = postMapper.toEntity(domain.getPost());

        return new CommentJpaEntity(
                domain.getCommentId(),
                userEntity,
                postEntity,
                domain.getContent(),
                domain.getCreateAt()
        );
    }
}
