package org.example.domain.post.dto.response;

import org.example.domain.comment.spi.vo.CommentDataWithLikeCntVO;
import org.example.domain.post.spi.vo.PostDataWithLikeCntVO;
import org.example.domain.reply.spi.vo.ReplyDataWithLikeCntVO;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record GetPostDetailResponseDto(
    String profile,
    String username,
    LocalDate createdAt,
    String title,
    String contents,
    String mainImg,
    Long likeCnt,
    List<CommentListItemDto> comments,
    List<ReplyListItemDto> replies
) {
    public static GetPostDetailResponseDto of(
        PostDataWithLikeCntVO postData,
        List<CommentDataWithLikeCntVO> comments,
        List<ReplyDataWithLikeCntVO> replies
    ) {
        return new GetPostDetailResponseDto(
            postData.profile(),
            postData.writer(),
            postData.createdAt(),
            postData.title(),
            postData.contents(),
            postData.mainImg(),
            postData.likeCnt(),
            comments.stream().map(CommentListItemDto::from).toList(),
            replies.stream().map(ReplyListItemDto::from).toList()
        );
    }
}

record CommentListItemDto(
    UUID commentId,
    String userId,
    String writer,
    String profile,
    String contents,
    LocalDate createdAt,
    Long likeCnt
) {
    public static CommentListItemDto from(CommentDataWithLikeCntVO commentData) {
        return new CommentListItemDto(
            commentData.commentId(),
            commentData.userId(),
            commentData.username(),
            commentData.profile(),
            commentData.content(),
            commentData.createdAt(),
            commentData.likeCnt()
        );
    }
}

record ReplyListItemDto(
    UUID commentId,
    UUID replyId,
    String userId,
    String writer,
    String profile,
    String contents,
    LocalDate createdAt,
    Long likeCnt
) {
    public static ReplyListItemDto from(ReplyDataWithLikeCntVO replyData) {
        return new ReplyListItemDto(
            replyData.commentId(),
            replyData.replyId(),
            replyData.userId(),
            replyData.username(),
            replyData.profile(),
            replyData.content(),
            replyData.createdAt(),
            replyData.likeCnt()
        );
    }
}