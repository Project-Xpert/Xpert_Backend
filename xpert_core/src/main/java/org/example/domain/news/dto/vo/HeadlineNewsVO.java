package org.example.domain.news.dto.vo;

import org.example.common.openAPI.news.vo.NewsItemsVO;
import org.example.common.util.DateFormatter;
import org.example.common.util.HtmlCodeRemover;

public record HeadlineNewsVO(
        String imageUrl,
        String title,
        String link,
        String company,
        String time
) {
    public static HeadlineNewsVO of(NewsItemsVO items, String company, String imageUrl) {
        String title = HtmlCodeRemover.removeHtmlCode(items.title());
        String formattedDate = DateFormatter.format(items.pubDate());

        return new HeadlineNewsVO(
                imageUrl,
                title,
                items.link(),
                company,
                formattedDate
        );
    }
}
