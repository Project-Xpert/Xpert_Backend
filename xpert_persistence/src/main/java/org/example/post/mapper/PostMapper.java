package org.example.post.mapper;

import lombok.RequiredArgsConstructor;
import org.example.GenericMapper;
import org.example.domain.post.model.Post;
import org.example.domain.user.model.User;
import org.example.post.entity.PostJpaEntity;
import org.example.user.entity.UserJpaEntity;
import org.example.user.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PostMapper implements GenericMapper<Post, PostJpaEntity> {
    private final UserMapper userMapper;

    @Override
    public Optional<Post> toDomain(Optional<PostJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        PostJpaEntity postEntity = entity.get();

        User user = userMapper.toDomain(Optional.of(postEntity.getUser())).get();

        return Optional.of(Post.builder()
                .postId(postEntity.getPostId())
                .user(user)
                .file(postEntity.getFile())
                .title(postEntity.getTitle())
                .content(postEntity.getContent())
                .createdAt(postEntity.getCreatedAt())
                .build()
        );
    }

    @Override
    public PostJpaEntity toEntity(Post domain) {
        UserJpaEntity userEntity = userMapper.toEntity(domain.getUser());

        return new PostJpaEntity(
                domain.getPostId(),
                userEntity,
                domain.getTitle(),
                domain.getContent(),
                domain.getFile(),
                domain.getCreatedAt()
        );
    }
}
