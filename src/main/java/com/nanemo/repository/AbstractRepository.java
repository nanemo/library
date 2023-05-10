package com.nanemo.repository;

import java.util.List;
import java.util.Optional;

public interface AbstractRepository<T> {

    List<T> getAll();
    Optional<T> getById(Integer id);
    void create(T t);
    void update(T t, Integer id);
    void delete(Integer id);

}
