package org.example.domain.post.dto.response;

import org.example.domain.post.dto.vo.PostListItemVO;

import java.util.List;

public record GetPostListResponseDto(
    List<PostListItemVO> posts
) {}