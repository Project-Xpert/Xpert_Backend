package org.example.post.repository;

import org.example.domain.post.spi.vo.PostDataWithLikeCntVO;
import org.example.post.entity.PostJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface PostJpaRepository extends CrudRepository<PostJpaEntity, UUID> {

    @Query("SELECT new org.example.domain.post.spi.vo.PostDataWithLikeCntVO(" +
                "p.postId, " +
                "p.user.username, " +
                "p.title, " +
                "p.createdAt, " +
                "count(p_like) " +
            ") " +
            "FROM post p LEFT OUTER JOIN post_like p_like ON p.postId = p_like.post.postId " +
            "GROUP BY p.postId, p.user.username, p.title, p.createdAt")
    List<PostDataWithLikeCntVO> getPostStatsList();
}
