package org.example.fx.repository;

import org.example.fx.entity.FxId;
import org.example.fx.entity.FxJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface FxJpaRepository extends CrudRepository<FxJpaEntity, FxId> {
}
