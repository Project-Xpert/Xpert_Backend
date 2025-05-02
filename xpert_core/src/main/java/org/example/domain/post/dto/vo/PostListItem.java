package org.example.domain.post.dto.vo;

import org.example.domain.post.spi.vo.PostDataWithLikeCntVO;

import java.time.LocalDate;
import java.util.UUID;

public record PostListItem(

        UUID postId,

        String writer,

        String title,

        LocalDate createdAt,

        Long likeCnt,

        int commentCnt
) {
    public static PostListItem of(PostDataWithLikeCntVO vo, int commentCnt) {
        return new PostListItem(
                vo.postId(),
                vo.writer(),
                vo.title(),
                vo.createdAt(),
                vo.likeCnt(),
                commentCnt
        );
    }
}
