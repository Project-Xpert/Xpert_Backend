package org.example.domain.post.dto.vo;

import org.example.domain.reply.spi.vo.ReplyDataWithLikeCntVO;

import java.time.LocalDate;
import java.util.UUID;

public record ReplyListItemVO(
        UUID commentId,
        UUID replyId,
        String userId,
        String writer,
        String profile,
        String contents,
        LocalDate createdAt,
        Boolean isLiked,
        Long likeCnt
) {
    public static ReplyListItemVO of(
            ReplyDataWithLikeCntVO replyData,
            Boolean hasLikedReply
    ) {
        return new ReplyListItemVO(
                replyData.commentId(),
                replyData.replyId(),
                replyData.userId(),
                replyData.username(),
                replyData.profile(),
                replyData.content(),
                replyData.createdAt(),
                hasLikedReply,
                replyData.likeCnt()
        );
    }
}