package org.example.fxData.repository;

import org.example.fxData.entity.FxDataId;
import org.example.fxData.entity.FxDataJpaEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface FxDataJpaRepository extends CrudRepository<FxDataJpaEntity, FxDataId> {
}
