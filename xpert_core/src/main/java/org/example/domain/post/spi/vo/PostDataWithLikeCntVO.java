package org.example.domain.post.spi.vo;

import java.time.LocalDate;
import java.util.UUID;

public record PostDataWithLikeCntVO(
    UUID postId,
    String profile,
    String userId,
    String writer,
    String title,
    String contents,
    String mainImg,
    LocalDate createdAt,
    Long likeCnt
) {
}
