package org.example.domain.post.spi.vo;

import java.time.LocalDate;
import java.util.UUID;

public record PostDataWithLikeCntVO(

        UUID postId,

        String writer,

        String title,

        LocalDate createdAt,

        Long likeCnt
) {
}
