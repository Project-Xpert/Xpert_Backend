package org.example.domain.post.dto.response;

import org.example.domain.post.dto.vo.CommentListItemVO;
import org.example.domain.post.dto.vo.ReplyListItemVO;
import org.example.domain.post.spi.vo.PostDataWithLikeCntVO;

import java.time.LocalDate;
import java.util.List;

public record GetPostDetailResponseDto(
    String profile,
    String username,
    LocalDate createdAt,
    String title,
    String contents,
    String mainImg,
    Boolean isLiked,
    Long likeCnt,
    List<CommentListItemVO> comments,
    List<ReplyListItemVO> replies
) {
    public static GetPostDetailResponseDto of(
            PostDataWithLikeCntVO postData,
            Boolean hasLikedPost,
            List<CommentListItemVO> comments,
            List<ReplyListItemVO> replies
    ) {
        return new GetPostDetailResponseDto(
                postData.profile(),
                postData.writer(),
                postData.createdAt(),
                postData.title(),
                postData.contents(),
                postData.mainImg(),
                hasLikedPost,
                postData.likeCnt(),
                comments,
                replies
        );
    }
}