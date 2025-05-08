package org.example.domain.fx.dto.response;

import org.example.domain.fx.model.FXType;
import org.example.domain.fx.model.FxData;
import org.example.domain.fx.spi.vo.FxDataWithRangeVO;

import java.util.List;

public record GetNewestFxDataResponseDto(
    List<FxDataWithRangeVO> data
) {
    public static GetNewestFxDataResponseDto from(List<FxDataWithRangeVO> fxDataList) {
        return new GetNewestFxDataResponseDto(fxDataList);
    }
}
