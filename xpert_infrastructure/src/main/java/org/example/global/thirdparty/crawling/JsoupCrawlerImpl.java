package org.example.global.thirdparty.crawling;

import lombok.extern.slf4j.Slf4j;
import org.example.common.crawler.JsoupCrawler;
import org.example.common.exception.general.InternalServerException;
import org.example.domain.news.dto.response.GetNewsDetailResponseDto;
import org.example.domain.news.dto.response.GetNewsListResponseDto;
import org.example.domain.news.dto.vo.BasicNewsVO;
import org.example.domain.news.dto.vo.HeadlineNewsVO;
import org.example.domain.news.dto.vo.ImageDataVO;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class JsoupCrawlerImpl implements JsoupCrawler {

    @Override
    public GetNewsListResponseDto NaverNewsListCrawling() {
        GetNewsListResponseDto result = null;

        String naverNewsUrl = "https://news.naver.com/section/101";
        String naverNewsEconomyUrl = "https://news.naver.com/breakingnews/section/101/259";
        String naverNewsCertificateUrl = "https://news.naver.com/breakingnews/section/101/258";

        Connection basicNewsConnection = Jsoup.connect(naverNewsUrl);
        Connection economyNewsConnection = Jsoup.connect(naverNewsEconomyUrl);
        Connection certificateNewsConnection = Jsoup.connect(naverNewsCertificateUrl);

        try {
            // 데이터 불러오기
            Document document = basicNewsConnection.get();

            Elements headLineElements = document.select(".sa_item._SECTION_HEADLINE .sa_item_flex");
            Elements basicNewsElements = document.select(".sa_item._LAZY_LOADING_WRAP");
            Elements economyNewsElements = economyNewsConnection.get().select("#SECTION_ARTICLE_LIST_FOR_LATEST .sa_item_flex");
            Elements certificateNewsElements = certificateNewsConnection.get().select("#SECTION_ARTICLE_LIST_FOR_LATEST .sa_item_flex");

            // 데이터 가공
            List<HeadlineNewsVO> headlineNewsVOList = new ArrayList<>();
            highlightNewsParser(headLineElements, headlineNewsVOList);

            List<BasicNewsVO> basicNewsVOList = new ArrayList<>();
            basicNewsParser(basicNewsElements, basicNewsVOList);
            basicNewsParser(economyNewsElements, basicNewsVOList);
            basicNewsParser(certificateNewsElements, basicNewsVOList);

            result = new GetNewsListResponseDto(headlineNewsVOList, basicNewsVOList);
        } catch(Exception e) {
            log.error(e.getMessage());
            throw InternalServerException.EXCEPTION;
        }

        return result;
    }

    @Override
    public GetNewsDetailResponseDto NaverNewsDetailCrawling(String url) {
        GetNewsDetailResponseDto result = null;
        Connection connection = Jsoup.connect(url);

        String newsImageRegexp = "(?s)<span[^>]*>\\s*<div[^>]*>.*?<div[^>]*>.*?<img[^>]*?>.*?</div>.*?</div>.*?</span>";

        try {
            Document document = connection.get();
            String newsBody = Arrays.stream(document.select("#dic_area").html()
                    .replaceAll("&.*?;", "")
                    .replaceAll(newsImageRegexp, " img_section ")
                    .replaceAll("<br/+>", "")
                    .replaceAll("(?s)<.*?>", "")
                    .split("\n"))
                    .filter(string -> !string.isBlank())
                    .map(String::trim)
                    .collect(Collectors.joining("\n\n"));

            List<ImageDataVO> imageDataVOList = new ArrayList<>();
            Elements imageElements = document.select(".end_photo_org");
            for (Element imageData: imageElements) {
                imageDataVOList.add(ImageDataVO.builder()
                        .link(imageData.select("img").attr("data-src"))
                        .description(imageData.select(".img_desc").text())
                        .build()
                );
            }

            result = GetNewsDetailResponseDto.builder()
                    .title(document.select("#title_area span").text())
                    .company(document.select(".c_text").text().split(" ")[2].replace(".", ""))
                    .time(document.select("._ARTICLE_DATE_TIME").text())
                    .contents(newsBody)
                    .imageData(imageDataVOList)
                    .build();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw InternalServerException.EXCEPTION;
        }

        return result;
    }

    private void highlightNewsParser(Elements elements, List<HeadlineNewsVO> list) {
        for (Element element: elements) {
            String imageUrl = element.select("img").attr("data-src").trim();
            if (!imageUrl.isEmpty()) {
                list.add(
                        HeadlineNewsVO.builder()
                                .title(element.select(".sa_text_strong").text().trim())
                                .link(element.select("a").attr("href").trim())
                                .company(element.select(".sa_text_press").text().trim())
                                .imageUrl(imageUrl)
                                .build()
                );
            }
        }
    }

    private void basicNewsParser(Elements elements, List<BasicNewsVO> list) {
        for (Element element :elements) {
            String imageUrl = element.select("img").attr("data-src").trim();
            if (!imageUrl.isEmpty()) {
                list.add(
                        BasicNewsVO.builder()
                                .title(element.select(".sa_text_strong").text().trim())
                                .link(element.select("a").attr("href").trim().trim())
                                .company(element.select(".sa_text_press").text().trim())
                                .imageUrl(imageUrl)
                                .build()
                );
            }
        }
    }
}
