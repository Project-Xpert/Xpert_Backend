package org.example.domain.post.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.comment.service.GetCommentService;
import org.example.domain.post.dto.response.GetPostDetailResponseDto;
import org.example.domain.post.dto.vo.CommentListItemVO;
import org.example.domain.post.dto.vo.ReplyListItemVO;
import org.example.domain.post.model.Post;
import org.example.domain.post.service.CheckPostLikeService;
import org.example.domain.post.service.GetPostService;
import org.example.domain.comment.spi.vo.CommentDataWithLikeCntVO;
import org.example.domain.post.spi.vo.PostDataWithLikeCntVO;
import org.example.domain.reply.spi.vo.ReplyDataWithLikeCntVO;
import org.example.domain.reply.service.GetReplyService;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetPostDetailUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final GetPostService getPostService;
    private final GetCommentService getCommentService;
    private final GetReplyService getReplyService;
    private final CheckPostLikeService checkPostLikeService;

    public GetPostDetailResponseDto execute(UUID postId) {
        User user = currentUserProvider.getCurrentUser();
        Post post = getPostService.getPostByPostId(postId);

        PostDataWithLikeCntVO postData = getPostService.getPostStatusByPostId(postId);
        List<CommentDataWithLikeCntVO> commentDataList = getCommentService.getCommentStatusListByPostId(postId);
        List<ReplyDataWithLikeCntVO> replyDataList = getReplyService.getReplyStatusListByPostId(postId);

        Boolean hasLikedPost = checkPostLikeService.getBooleanOfExistsByPostAndUser(post, user);
        List<CommentListItemVO> commentListItems = new ArrayList<>();
        List<ReplyListItemVO> replyListItems = new ArrayList<>();

        return GetPostDetailResponseDto.of(postData, hasLikedPost, commentListItems, replyListItems);
    }
}
