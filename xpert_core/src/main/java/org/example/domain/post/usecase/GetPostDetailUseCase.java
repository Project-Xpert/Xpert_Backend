package org.example.domain.post.usecase;

import lombok.RequiredArgsConstructor;
import org.example.domain.comment.service.GetCommentService;
import org.example.domain.post.dto.response.GetPostDetailResponseDto;
import org.example.domain.post.service.GetPostService;
import org.example.domain.comment.spi.vo.CommentDataWithLikeCntVO;
import org.example.domain.post.spi.vo.PostDataWithLikeCntVO;
import org.example.domain.reply.spi.vo.ReplyDataWithLikeCntVO;
import org.example.domain.reply.service.GetReplyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetPostDetailUseCase {
    private final GetPostService getPostService;
    private final GetCommentService getCommentService;
    private final GetReplyService getReplyService;

    public GetPostDetailResponseDto execute(UUID postId) {
        PostDataWithLikeCntVO postData = getPostService.getPostStatusByPostId(postId);
        List<CommentDataWithLikeCntVO> commentDataList = getCommentService.getCommentStatusListByPostId(postId);
        List<ReplyDataWithLikeCntVO> replyDataList = getReplyService.getReplyStatusListByPostId(postId);

        return GetPostDetailResponseDto.of(postData, commentDataList, replyDataList);
    }
}
