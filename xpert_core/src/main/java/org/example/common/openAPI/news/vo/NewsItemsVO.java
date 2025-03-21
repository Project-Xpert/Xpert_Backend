package org.example.common.openAPI.news.vo;

public record NewsItemsVO(
        String title,
        String link,
        String description,
        String pubDate
) {
}
