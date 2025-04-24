package org.example.domain.comment.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.domain.post.model.Post;
import org.example.domain.user.model.User;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
public class Comment {

    private UUID commentId;

    private User user;

    private Post post;

    private String content;

    private LocalDate createAt;
}
