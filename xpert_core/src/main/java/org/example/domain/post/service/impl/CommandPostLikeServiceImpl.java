package org.example.domain.post.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.post.model.PostLike;
import org.example.domain.post.service.CommandPostLikeService;
import org.example.domain.post.spi.QueryPostLikePort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandPostLikeServiceImpl implements CommandPostLikeService {
    private final QueryPostLikePort queryPostLikePort;

    @Override
    public void savePostLike(PostLike postLike) {
        queryPostLikePort.saveLike(postLike);
    }

    @Override
    public void deletePostLike(PostLike postLike) {
        queryPostLikePort.deleteLike(postLike);
    }
}
