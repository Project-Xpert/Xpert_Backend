package org.example.domain.comment.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.comment.exception.CommentNotFoundException;
import org.example.domain.comment.model.Comment;
import org.example.domain.comment.service.GetCommentService;
import org.example.domain.comment.spi.QueryCommentPort;
import org.example.domain.post.model.Post;
import org.example.domain.comment.spi.vo.CommentDataWithLikeCntVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetCommentServiceImpl implements GetCommentService {
    private final QueryCommentPort queryCommentPort;

    @Override
    public Comment findCommentByCommentId(UUID commentId) {
        return queryCommentPort.findCommentByCommentId(commentId).orElseThrow(
                () -> CommentNotFoundException.EXCEPTION
        );
    }

    @Override
    public int getTotalCommentCnt(Post post) {
        return queryCommentPort.countByPost(post);
    }

    @Override
    public List<CommentDataWithLikeCntVO> getCommentStatusListByPostId(UUID postId) {
        return queryCommentPort.getCommentStatusListByPostId(postId);
    }
}
