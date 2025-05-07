package org.example.fx;

import lombok.RequiredArgsConstructor;
import org.example.fx.mapper.FxMapper;
import org.example.fx.repository.FxJpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FxPersistenceAdapter {
    private final FxJpaRepository fxJpaRepository;
    private final FxMapper fxMapper;
}
