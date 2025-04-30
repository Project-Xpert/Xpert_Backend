package org.example.domain.post.spi;

import org.example.domain.post.model.Post;
import org.example.domain.post.model.PostLike;
import org.example.domain.user.model.User;

public interface QueryPostLikePort {

    Boolean existsByPostAndUser(Post post, User user);

    void saveLike(PostLike postLike);

    void deleteLike(PostLike postLike);
}
