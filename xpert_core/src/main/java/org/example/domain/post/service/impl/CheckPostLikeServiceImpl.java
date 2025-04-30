package org.example.domain.post.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.post.model.Post;
import org.example.domain.post.service.CheckPostLikeService;
import org.example.domain.post.spi.QueryPostLikePort;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckPostLikeServiceImpl implements CheckPostLikeService {
    private final QueryPostLikePort queryPostLikePort;

    @Override
    public Boolean getBooleanOfExistsByPostAndUser(Post post, User user) {
        return queryPostLikePort.existsByPostAndUser(post, user);
    }
}
