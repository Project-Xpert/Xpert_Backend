package org.example.domain.news.dto.response;

import org.example.domain.news.dto.vo.BasicNewsVO;
import org.example.domain.news.dto.vo.HeadlineNewsVO;

import java.util.List;

public record GetNewsListResponseDto(
        List<HeadlineNewsVO> headlines,
        List<BasicNewsVO> news
) {
}
