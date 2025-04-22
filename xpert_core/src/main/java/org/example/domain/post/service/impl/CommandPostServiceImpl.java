package org.example.domain.post.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.post.model.Post;
import org.example.domain.post.service.CommandPostService;
import org.example.domain.post.spi.QueryPostPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandPostServiceImpl implements CommandPostService {
    private final QueryPostPort queryPostPort;

    @Override
    public void savePost(Post post) {
        queryPostPort.savePost(post);
    }
}
