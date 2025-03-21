package org.example.domain.news.dto.vo;

import lombok.Builder;

@Builder
public record BasicNewsVO (
        String imageUrl,
        String title,
        String link,
        String company
) { }
