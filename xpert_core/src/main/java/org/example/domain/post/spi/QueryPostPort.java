package org.example.domain.post.spi;

import org.example.domain.post.model.Post;

public interface QueryPostPort {

    void savePost(Post post);
}
