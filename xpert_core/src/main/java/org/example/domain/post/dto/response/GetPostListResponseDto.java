package org.example.domain.post.dto.response;

import org.example.domain.post.dto.vo.PostListItem;

import java.util.List;

public record GetPostListResponseDto(
    List<PostListItem> posts
) {}