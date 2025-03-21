package org.example.domain.news.dto.response;

import lombok.Builder;

@Builder
public record GetNewsDetailResponseDto(
        String title,
        String imageUrl,
        String company,
        String time,
        String contents
) {
}
