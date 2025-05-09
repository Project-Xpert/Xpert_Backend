package org.example.fx.repository;

import org.example.domain.fx.model.FxType;
import org.example.domain.fx.spi.vo.OwnFxVO;
import org.example.fx.entity.FxId;
import org.example.fx.entity.FxJpaEntity;
import org.example.user.entity.UserJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface FxJpaRepository extends CrudRepository<FxJpaEntity, FxId> {

    @Query("""
        SELECT
            new org.example.domain.fx.spi.vo.OwnFxVO(
               f.amount,
               f.sumOfBuy
            )
        FROM
            fx f
        WHERE
            f.user = :user
            AND f.type = :fxType
    """)
    Optional<OwnFxVO> getFxOwnDataByUserAndFxType(
            @Param("user") UserJpaEntity user,
            @Param("fxType") FxType fxType
    );
}
