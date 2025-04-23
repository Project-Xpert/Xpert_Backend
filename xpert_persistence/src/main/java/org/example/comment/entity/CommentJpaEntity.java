package org.example.comment.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.post.entity.PostJpaEntity;
import org.example.user.entity.UserJpaEntity;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@DynamicInsert
@DynamicUpdate
@Entity(name = "comment")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentJpaEntity {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID commentId;

    @ManyToOne(targetEntity = UserJpaEntity.class, optional = false)
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    private UserJpaEntity user;

    @ManyToOne(targetEntity = PostJpaEntity.class, optional = false)
    @JoinColumn(name = "postId", referencedColumnName = "postId", nullable = false)
    private PostJpaEntity post;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String content;

    @ColumnDefault("(CURRENT_DATE)")
    @Column(columnDefinition = "DATE", nullable = false)
    private LocalDate createdAt;
}