package org.example.global.thirdparty.crawling;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JsoupCrawler {
    public Optional<Elements> getJsoupElementsByCssQuery(String url, String cssQuery) {
        Connection connection = Jsoup.connect(url);

        try {
            return Optional.of(connection.get().select(cssQuery));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
