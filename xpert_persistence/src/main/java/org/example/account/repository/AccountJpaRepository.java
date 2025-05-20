package org.example.account.repository;

import org.example.account.entity.AccountJpaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface AccountJpaRepository extends CrudRepository<AccountJpaEntity, UUID> {

    List<AccountJpaEntity> getAccountJpaEntitiesByDay(int day);
}
