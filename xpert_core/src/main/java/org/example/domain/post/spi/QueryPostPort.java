package org.example.domain.post.spi;

import org.example.domain.post.model.Post;
import org.example.domain.post.spi.vo.PostDataWithLikeCntVO;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface QueryPostPort {

    void savePost(Post post);

    Optional<Post> getPostByPostId(UUID postId);

    void deletePost(Post post);

    List<PostDataWithLikeCntVO> getPostStatusList();

    Optional<PostDataWithLikeCntVO> getPostStatusByPostId(UUID postId);
}
