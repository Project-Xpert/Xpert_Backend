package org.example.domain.news.dto.response;

import lombok.Builder;
import org.example.domain.news.dto.vo.ImageDataVO;

import java.util.List;

@Builder
public record GetNewsDetailResponseDto(
        String title,
        String company,
        String time,
        String contents,
        List<ImageDataVO> imageData
) {
}
