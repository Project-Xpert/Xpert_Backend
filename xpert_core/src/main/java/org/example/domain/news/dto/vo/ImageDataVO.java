package org.example.domain.news.dto.vo;

import lombok.Builder;

@Builder
public record ImageDataVO(
        String link,
        String description
) {
}
