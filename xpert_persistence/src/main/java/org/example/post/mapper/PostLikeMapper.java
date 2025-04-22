package org.example.post.mapper;

import lombok.RequiredArgsConstructor;
import org.example.GenericMapper;
import org.example.domain.post.model.PostLike;
import org.example.domain.post.model.Post;
import org.example.domain.user.model.User;
import org.example.post.entity.PostLikeJpaEntity;
import org.example.user.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PostLikeMapper implements GenericMapper<PostLike, PostLikeJpaEntity> {
    private final UserMapper userMapper;
    private final PostMapper postMapper;

    @Override
    public Optional<PostLike> toDomain(Optional<PostLikeJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        PostLikeJpaEntity likeEntity = entity.get();

        User user = userMapper.toDomain(Optional.of(likeEntity.getUser())).get();
        Post post = postMapper.toDomain(Optional.of(likeEntity.getPost())).get();

        return Optional.of(PostLike.builder()
                .user(user)
                .post(post)
                .build()
        );
    }

    @Override
    public PostLikeJpaEntity toEntity(PostLike domain) {
        return null;
    }
}
