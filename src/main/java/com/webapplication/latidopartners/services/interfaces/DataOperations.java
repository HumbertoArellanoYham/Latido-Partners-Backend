package com.webapplication.latidopartners.services.interfaces;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public interface DataOperations<T> {
    List<T> findAll();

    Optional<T> findById(Long id);

    // This work for save and update to entity data
    T save(T t);

    void remove(Long id);

    void removeForEntity(T t);

    Optional<T> saveOptional(T t);
}
