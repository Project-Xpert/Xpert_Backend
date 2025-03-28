package org.example.gold.repository;

import org.example.gold.entity.GoldId;
import org.example.gold.entity.GoldJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface GoldJpaRepository extends CrudRepository<GoldJpaEntity, GoldId> {
}
