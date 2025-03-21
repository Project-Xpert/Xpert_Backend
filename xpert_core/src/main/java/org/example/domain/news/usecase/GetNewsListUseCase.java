package org.example.domain.news.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.crawler.JsoupCrawler;
import org.example.domain.news.dto.response.GetNewsListResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetNewsListUseCase {
    private final JsoupCrawler jsoupCrawler;

    public GetNewsListResponseDto execute() {
        return jsoupCrawler.NaverNewsListCrawling();
    }
}
