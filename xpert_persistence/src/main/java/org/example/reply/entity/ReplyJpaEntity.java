package org.example.reply.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.comment.entity.CommentJpaEntity;
import org.example.user.entity.UserJpaEntity;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@DynamicInsert
@DynamicUpdate
@Entity(name = "reply")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReplyJpaEntity {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID replyId;

    @ManyToOne(targetEntity = UserJpaEntity.class, optional = false)
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    private UserJpaEntity user;

    @ManyToOne(targetEntity = CommentJpaEntity.class, optional = false)
    @JoinColumn(name = "commentId", referencedColumnName = "commentId", nullable = false)
    private CommentJpaEntity comment;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String content;

    @ColumnDefault("(CURRENT_DATE)")
    @Column(columnDefinition = "DATE", nullable = false)
    private LocalDate createdAt;
}
