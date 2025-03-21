package org.example;

import lombok.RequiredArgsConstructor;
import org.example.domain.news.dto.response.GetNewsDetailResponseDto;
import org.example.domain.news.dto.response.GetNewsListResponseDto;
import org.example.domain.news.usecase.GetNewsDetailUseCase;
import org.example.domain.news.usecase.GetNewsListUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/news")
@RequiredArgsConstructor
public class NewsWebAdapter {
    private final GetNewsListUseCase getNewsListUseCase;
    private final GetNewsDetailUseCase getNewsDetailUseCase;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/list")
    public GetNewsListResponseDto getNewsListUseCase() {
        return getNewsListUseCase.execute();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/detail")
    public GetNewsDetailResponseDto getNewsDetail(@RequestParam("link") String link) {
        return getNewsDetailUseCase.execute(link);
    }
}
