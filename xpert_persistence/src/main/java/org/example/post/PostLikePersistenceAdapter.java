package org.example.post;

import lombok.RequiredArgsConstructor;
import org.example.domain.post.model.Post;
import org.example.domain.post.model.PostLike;
import org.example.domain.post.spi.QueryPostLikePort;
import org.example.domain.user.model.User;
import org.example.post.entity.LikeId;
import org.example.post.mapper.PostLikeMapper;
import org.example.post.mapper.PostMapper;
import org.example.post.repository.PostLikeJpaRepository;
import org.example.user.mapper.UserMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostLikePersistenceAdapter implements QueryPostLikePort {
    private final PostLikeJpaRepository postLikeJpaRepository;
    private final PostLikeMapper postLikeMapper;
    private final PostMapper postMapper;
    private final UserMapper userMapper;

    @Override
    public Boolean existsByPostAndUser(Post post, User user) {
        return postLikeJpaRepository.existsById(new LikeId(
                postMapper.toEntity(post),
                userMapper.toEntity(user)
        ));
    }

    @Override
    public void saveLike(PostLike postLike) {
        postLikeJpaRepository.save(postLikeMapper.toEntity(postLike));
    }

    @Override
    public void deleteLike(PostLike postLike) {
        postLikeJpaRepository.delete(postLikeMapper.toEntity(postLike));
    }
}
