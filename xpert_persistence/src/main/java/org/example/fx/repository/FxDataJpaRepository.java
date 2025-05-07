package org.example.fx.repository;

import org.example.fx.entity.FxDataId;
import org.example.fx.entity.FxDataJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface FxDataJpaRepository extends CrudRepository<FxDataJpaEntity, FxDataId> {
}
