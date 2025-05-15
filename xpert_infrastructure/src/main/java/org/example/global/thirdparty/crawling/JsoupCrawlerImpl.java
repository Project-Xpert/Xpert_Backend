package org.example.global.thirdparty.crawling;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.common.crawler.JsoupCrawler;
import org.example.domain.news.dto.response.GetNewsDetailResponseDto;
import org.example.domain.news.dto.response.GetNewsListResponseDto;
import org.example.global.thirdparty.crawling.crawlers.NaverNewsCrawler;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class JsoupCrawlerImpl implements JsoupCrawler {
    private final NaverNewsCrawler naverNewsCrawler;

    @Override
    public GetNewsListResponseDto NaverNewsListCrawling() {
        return naverNewsCrawler.getNewsList();
    }

    @Override
    public GetNewsDetailResponseDto NaverNewsDetailCrawling(String url) {
        return naverNewsCrawler.getDetail(url);
    }
}