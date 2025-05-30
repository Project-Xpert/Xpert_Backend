package org.example.domain.post.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.post.model.Post;
import org.example.domain.post.exception.PostNotFoundException;
import org.example.domain.post.service.GetPostService;
import org.example.domain.post.spi.QueryPostPort;
import org.example.domain.post.spi.vo.PostDataWithLikeCntVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetPostServiceImpl implements GetPostService {
    private final QueryPostPort queryPostPort;

    @Override
    public Post getPostByPostId(UUID postId) {
        return queryPostPort.getPostByPostId(postId).orElseThrow(
                () -> PostNotFoundException.EXCEPTION
        );
    }

    @Override
    public List<PostDataWithLikeCntVO> getPostStatusList() {
        return queryPostPort.getPostStatusList();
    }

    @Override
    public PostDataWithLikeCntVO getPostStatusByPostId(UUID postId) {
        return queryPostPort.getPostStatusByPostId(postId).orElseThrow(
                () -> PostNotFoundException.EXCEPTION
        );
    }
}
