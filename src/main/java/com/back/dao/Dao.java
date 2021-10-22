package com.back.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T, Id extends Serializable> {
    default void init() {

    }
    public void persist(T entity);

    public void update(T entity);

    public T findById(Id id);

    public void delete(T entity);

    public List<T> findAll();

    public void deleteAll();

}
