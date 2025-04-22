package org.example.post.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.user.entity.UserJpaEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.UUID;

@Getter
@DynamicInsert
@DynamicUpdate
@Entity(name = "post")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostJpaEntity {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID postId;

    @ManyToOne(targetEntity = UserJpaEntity.class, optional = false)
    @JoinColumn(referencedColumnName = "userId", name = "userId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserJpaEntity user;

    @Column(columnDefinition = "VARCHAR(40)", nullable = false)
    private String title;

    @Column(columnDefinition = "VARCHAR(300)", nullable = false)
    private String content;

    @Column(columnDefinition = "varchar(150)", nullable = true)
    private String file;
}
