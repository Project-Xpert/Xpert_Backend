package org.example.domain.stock.modal;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum StockCategory {
    OIL("석유 시추 및 정제"),
    SOFTWARE("소프트웨어 및 클라우드"),
    HARDWARE("반도체 및 전자장비"),
    FINANCE("금융업"),
    TRANSPORTATION("이동수단 운영 및 제조"),
    RETAIL("유통 및 소매업"),
    BIO("바이오 & 의료"),
    MEDIA("미디어 제작 및 유통"),
    FOOD_BEVERAGE("요식업"),
    DEFENCE_AND_AEROSPACE("방산 및 항공우주 산업"),
    PAYMENT("결제 및 핀테크"),
    GAME("게임 개발 및 유통"),
    OTHER("기타 산업");


    private final String name;
}
