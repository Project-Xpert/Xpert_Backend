package org.example.post;

import lombok.RequiredArgsConstructor;
import org.example.domain.post.model.Post;
import org.example.domain.post.spi.QueryPostPort;
import org.example.domain.post.spi.vo.PostDataWithLikeCntVO;
import org.example.post.mapper.PostMapper;
import org.example.post.repository.PostJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PostPersistenceAdapter implements QueryPostPort {
    private final PostJpaRepository postJpaRepository;
    private final PostMapper postMapper;

    @Override
    public void savePost(Post post) {
        postJpaRepository.save(
                postMapper.toEntity(post)
        );
    }

    @Override
    public Optional<Post> getPostByPostId(UUID postId) {
        return postMapper.toDomain(
                postJpaRepository.findById(postId)
        );
    }

    @Override
    public void deletePost(Post post) {
        postJpaRepository.delete(
                postMapper.toEntity(post)
        );
    }

    @Override
    public List<PostDataWithLikeCntVO> getPostStatusList() {
        return postJpaRepository.getPostStatusList();
    }

    @Override
    public Optional<PostDataWithLikeCntVO> getPostStatusByPostId(UUID postId) {
        return postJpaRepository.getPostStatusByPostId(postId);
    }
}
