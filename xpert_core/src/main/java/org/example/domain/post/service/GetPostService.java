package org.example.domain.post.service;

import org.example.domain.post.model.Post;
import org.example.domain.post.spi.vo.PostDataWithLikeCntVO;

import java.util.List;
import java.util.UUID;

public interface GetPostService {

    Post getPostByPostId(UUID postId);

    List<PostDataWithLikeCntVO> getPostStatsList();
}
