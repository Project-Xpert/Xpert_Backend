package org.example.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@DynamicInsert
@DynamicUpdate
@Entity(name = "user")
@AllArgsConstructor
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class UserJpaEntity {
    @Id
    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    private String userId;

    @Column(columnDefinition = "VARCHAR(25)", nullable = false, unique = true)
    private String email;

    @Column(columnDefinition = "VARCHAR(15)", nullable = false)
    private String username;

    @Column(columnDefinition = "VARCHAR(225)", nullable = false)
    private String password;

    @ColumnDefault("'https://randcs-bucket.s3.ap-northeast-2.amazonaws.com/c2669a30-d649-40b6-9dbf-b3775724a82b'")
    @Column(columnDefinition = "VARCHAR(200)", nullable = false)
    private String profile;

    @ColumnDefault("2000000")
    @Column(columnDefinition = "INT UNSIGNED", nullable = false)
    private Long money;
}
