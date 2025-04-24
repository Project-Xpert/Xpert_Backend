package org.example.domain.gold.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Gold {

    private GoldType goldType;

    private String userId;

    private int cnt;
}
