package org.example.domain.comment.service;

import org.example.domain.comment.model.Comment;
import org.example.domain.post.model.Post;
import org.example.domain.comment.spi.vo.CommentDataWithLikeCntVO;

import java.util.List;
import java.util.UUID;

public interface GetCommentService {

    Comment findCommentByCommentId(UUID commentId);

    int getTotalCommentCnt(Post post);

    List<CommentDataWithLikeCntVO> getCommentStatusListByPostId(UUID postId);
}
