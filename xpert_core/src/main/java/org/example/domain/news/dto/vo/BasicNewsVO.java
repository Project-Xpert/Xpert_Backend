package org.example.domain.news.dto.vo;

import org.example.common.openAPI.news.vo.NewsItemsVO;
import org.example.common.util.DateFormatter;
import org.example.common.util.HtmlCodeRemover;

import java.util.Optional;

public record BasicNewsVO (
        Optional<String> imageUrl,
        String title,
        String link,
        String company,
        String time
) {
    public static BasicNewsVO of(NewsItemsVO items, String company, Optional<String> imageUrl) {
        String title = HtmlCodeRemover.removeHtmlCode(items.title());
        String formattedDate = DateFormatter.format(items.pubDate());

        return new BasicNewsVO(
                imageUrl,
                title,
                items.link(),
                company,
                formattedDate
        );
    }
}
