package org.example.common.openAPI.gold.vo;

import java.util.Map;

public record GoldAPIResponseVO(
        Map<String, GoldBodyVO> response
) {
}
