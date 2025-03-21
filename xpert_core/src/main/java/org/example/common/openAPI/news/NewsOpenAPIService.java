package org.example.common.openAPI.news;

import org.example.domain.news.dto.response.GetNewsListResponseDto;

public interface NewsOpenAPIService {

    GetNewsListResponseDto GetNewsData();
}
