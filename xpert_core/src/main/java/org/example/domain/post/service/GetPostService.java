package org.example.domain.post.service;

import org.example.domain.post.model.Post;

import java.util.UUID;

public interface GetPostService {

    Post getPostByPostId(UUID postId);
}
