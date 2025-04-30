package org.example.domain.post.service;

import org.example.domain.post.model.PostLike;

public interface CommandPostLikeService {

    void savePostLike(PostLike postLike);

    void deletePostLike(PostLike postLike);
}
