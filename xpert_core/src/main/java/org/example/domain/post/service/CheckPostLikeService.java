package org.example.domain.post.service;

import org.example.domain.post.model.Post;
import org.example.domain.user.model.User;

public interface CheckPostLikeService {

    Boolean getBooleanOfExistsByPostAndUser(Post post, User user);
}
