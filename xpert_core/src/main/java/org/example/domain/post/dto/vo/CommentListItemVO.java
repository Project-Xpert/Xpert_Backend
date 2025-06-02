package org.example.domain.post.dto.vo;

import org.example.domain.comment.spi.vo.CommentDataWithLikeCntVO;

import java.time.LocalDate;
import java.util.UUID;

public record CommentListItemVO(
        UUID commentId,
        String userId,
        String writer,
        String profile,
        String contents,
        LocalDate createdAt,
        Boolean isLiked,
        Long likeCnt
) {
    public static CommentListItemVO of(
            CommentDataWithLikeCntVO commentData,
            Boolean hasLikedComment
    ) {
        return new CommentListItemVO(
                commentData.commentId(),
                commentData.userId(),
                commentData.username(),
                commentData.profile(),
                commentData.content(),
                commentData.createdAt(),
                hasLikedComment,
                commentData.likeCnt()
        );
    }
}
