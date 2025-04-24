package org.example.domain.post.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.domain.user.model.User;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
public class Post {

    private UUID postId;

    private User user;

    private String title;

    private String content;

    private String file;

    private LocalDate createdAt;
}
