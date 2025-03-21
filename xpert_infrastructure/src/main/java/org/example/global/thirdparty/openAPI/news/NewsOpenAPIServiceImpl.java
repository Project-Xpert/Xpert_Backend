package org.example.global.thirdparty.openAPI.news;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.RequiredArgsConstructor;
import org.example.common.openAPI.news.NewsOpenAPIService;
import org.example.common.openAPI.news.vo.NewsItemsVO;
import org.example.common.openAPI.news.vo.NewsResponseDto;
import org.example.domain.news.dto.response.GetNewsListResponseDto;
import org.example.domain.news.dto.vo.BasicNewsVO;
import org.example.domain.news.dto.vo.HeadlineNewsVO;
import org.example.global.thirdparty.crawling.JsoupCrawler;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;

import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;


@Service
@RequiredArgsConstructor
public class NewsOpenAPIServiceImpl implements NewsOpenAPIService {
    private final JsoupCrawler jsoupCrawler;

    @Value("${openAPI.news.client_id}")
    private String clientId;
    @Value("${openAPI.news.client_secret}")
    private String clientSecret;

    @Override
    public GetNewsListResponseDto GetNewsData() {
        NewsResponseDto response = getNewsData();

        List<HeadlineNewsVO> headlineNewsVOList = new ArrayList<>();
        List<BasicNewsVO> basicNewsVOList = new ArrayList<>();
        for (NewsItemsVO item : response.items()) {
            if (item.link().startsWith("https://n.news.naver")) {
                String imageUrl = getImageOfNews(item);
                String companyName = getNewsName(item);

                if (imageUrl != null && !imageUrl.isEmpty() && headlineNewsVOList.size() < 6) {
                    headlineNewsVOList.add(HeadlineNewsVO.of(item, companyName, imageUrl));
                } else {
                    basicNewsVOList.add(BasicNewsVO.of(item, companyName, Optional.ofNullable(imageUrl)));
                }
            }
        }

        return new GetNewsListResponseDto(headlineNewsVOList, basicNewsVOList);
    }

    private WebClient getWebClient() {
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .responseTimeout(Duration.ofMinutes(3))
                .doOnConnected(connection ->
                        connection.addHandlerLast(new ReadTimeoutHandler(3, TimeUnit.MINUTES))
                                .addHandlerLast(new WriteTimeoutHandler(3, TimeUnit.MINUTES))
                );

        WebClient webClient = WebClient.builder()
                .baseUrl("https://openapi.naver.com/v1/search/news.json")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("X-Naver-Client-Id", clientId)
                .defaultHeader("X-Naver-Client-Secret", clientSecret)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();

        return webClient;
    }

    private NewsResponseDto getNewsData() {
        WebClient webClient = getWebClient();

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("query", "투자 관련 뉴스")
                        .queryParam("display", 100)
                        .queryParam("start", 1)
                        .build())
                .retrieve()
                .bodyToMono(NewsResponseDto.class)
                .block();
    }

    private String getImageOfNews(NewsItemsVO item) {
        Optional<Elements> imageElement = jsoupCrawler.getJsoupElementsByCssQuery(
                item.link(), "#contents img"
        );

        String imageLink = null;
        if (imageElement.isPresent()) {
            imageLink = imageElement.get().attr("data-src");
        }

        return imageLink;
    }

    private String getNewsName(NewsItemsVO item) {
        Optional<Elements> newsNameElement = jsoupCrawler.getJsoupElementsByCssQuery(
                item.link(), ".c_text"
        );

        return newsNameElement.get().text().split(" ")[2].replace(".", "").trim();
    }
}
