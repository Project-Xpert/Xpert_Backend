package org.example.domain.post.usecase;

import lombok.RequiredArgsConstructor;
import org.example.domain.comment.service.GetCommentService;
import org.example.domain.post.dto.response.GetPostListResponseDto;
import org.example.domain.post.dto.vo.PostListItem;
import org.example.domain.post.service.GetPostService;
import org.example.domain.post.spi.vo.PostDataWithLikeCntVO;
import org.example.domain.reply.service.GetReplyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetPostListUseCase {
    private final GetPostService getPostService;
    private final GetCommentService getCommentService;

    public GetPostListResponseDto execute() {
        List<PostDataWithLikeCntVO> postData = getPostService.getPostStatsList();

        List<PostListItem> postListItems = new ArrayList<>();

        for (PostDataWithLikeCntVO postDatum: postData) {
            int commentCnt = getCommentService.getTotalCommentCnt(
                    getPostService.getPostByPostId(postDatum.postId())
            );

            postListItems.add(PostListItem.of(postDatum, commentCnt));
        }

        return new GetPostListResponseDto(postListItems);
    }
}