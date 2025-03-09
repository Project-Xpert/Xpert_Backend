package org.example;

import java.util.Optional;

public interface GenericMapper<D, E> {

    Optional<D> toDomain(Optional<E> entity);

    E toEntity(D domain);
}
