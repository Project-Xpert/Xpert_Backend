package org.example.domain.comment.spi;

import org.example.domain.comment.model.Comment;
import org.example.domain.post.model.Post;
import org.example.domain.comment.spi.vo.CommentDataWithLikeCntVO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface QueryCommentPort {

    void saveComment(Comment comment);

    Optional<Comment> findCommentByCommentId(UUID commentId);

    void deleteComment(Comment comment);

    int countByPost(Post post);

    List<CommentDataWithLikeCntVO> getCommentStatusListByPostId(UUID postId);
}
