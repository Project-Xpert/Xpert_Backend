package org.example.account.repository;

import org.example.account.entity.AccountJpaEntity;
import org.example.user.entity.UserJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface AccountJpaRepository extends CrudRepository<AccountJpaEntity, UUID> {

    List<AccountJpaEntity> getAccountJpaEntitiesByDay(int day);

    List<AccountJpaEntity> getAccountJpaEntitiesByUser(UserJpaEntity entity);


    @Query("SELECT account " +
            "FROM account a " +
            "WHERE (a.isOverdue = true OR a.expireAt = 0) AND a.day = :deleteDay")
    List<AccountJpaEntity> getAccountsNeedToDelete(@Param("deleteDay") int deleteDayOfWeek);
}
