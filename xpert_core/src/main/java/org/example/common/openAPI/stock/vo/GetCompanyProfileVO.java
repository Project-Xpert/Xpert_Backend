package org.example.common.openAPI.stock.vo;

public record GetCompanyProfileVO(
    long mcp,
    long shareOutstanding,
    String ipo,
    String companyFullName
) {
}
