package org.example.global.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.extern.slf4j.Slf4j;
import org.example.common.exception.general.InternalServerException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Slf4j
@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .defaultHeader(HttpHeaders.USER_AGENT, "Mozilla/5.0")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .clientConnector(new ReactorClientHttpConnector(createHttpClient()))
                .build();
    }

    private HttpClient createHttpClient() {
        return HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .responseTimeout(Duration.ofMinutes(3))
                .doOnConnected(connection ->
                        connection.addHandlerLast(new ReadTimeoutHandler(3000, TimeUnit.MILLISECONDS))
                                .addHandlerLast(new WriteTimeoutHandler(1500, TimeUnit.MILLISECONDS))
                )
                .secure(sslContextSpec -> sslContextSpec.sslContext(
                        createSSLContext()
                ));
    }

    private SslContext createSSLContext() {
        try {
            return SslContextBuilder.forClient()
                    .protocols("TLSv1.2")
                    .build();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw InternalServerException.EXCEPTION;
        }
    }
}
