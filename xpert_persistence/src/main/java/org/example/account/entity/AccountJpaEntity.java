package org.example.account.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.domain.account.model.AccountType;
import org.example.domain.account.model.InterestType;
import org.example.user.entity.UserJpaEntity;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@DynamicInsert
@Entity(name = "account")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "BINARY(16)", nullable = false)
    UUID accountId;

    @ManyToOne(targetEntity = UserJpaEntity.class, optional = false)
    @JoinColumn(name="userId", referencedColumnName = "userId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    UserJpaEntity user;

    @Column(columnDefinition = "VARCHAR(30)", nullable = false)
    String productName;

    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    String companyName;

    @Column(columnDefinition = "INTEGER", nullable = false)
    int money;

    @ColumnDefault("0")
    @Column(columnDefinition = "INTEGER", nullable = false)
    int interest;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    AccountType accountType;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    InterestType interestType;

    @Column(columnDefinition = "FLOAT", nullable = false)
    Double rate;

    @Column(columnDefinition = "TINYINT", nullable = false)
    Boolean autoTransfer;

    @ColumnDefault("0")
    @Column(columnDefinition = "INTEGER", nullable = false)
    int autoTransferAmount;

    @Column(columnDefinition = "INTEGER", nullable = false)
    int day;

    @ColumnDefault("(CURRENT_DATE)")
    @Column(columnDefinition = "date", nullable = false)
    LocalDate expireAt;

    @ColumnDefault("0")
    @Column(columnDefinition = "TINYINT", nullable = false)
    Boolean isOverdue;
}
