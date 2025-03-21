package org.example.domain.news.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.crawler.JsoupCrawler;
import org.example.domain.news.dto.response.GetNewsDetailResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetNewsDetailUseCase {
    private final JsoupCrawler jsoupCrawler;

    public GetNewsDetailResponseDto execute(String link) {
        return jsoupCrawler.NaverNewsDetailCrawling(link);
    }
}
