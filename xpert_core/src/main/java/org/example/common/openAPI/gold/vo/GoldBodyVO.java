package org.example.common.openAPI.gold.vo;

import java.util.List;
import java.util.Map;

public record GoldBodyVO(
        int numOfRows,
        int totalCount,
        Map<String, List<GoldItemVO>> items
) {
}
