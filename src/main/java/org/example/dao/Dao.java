package org.example.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T, Id extends Serializable> {
    default void init() {

    }
    public void persist(T entity);


    public T findById(Id id);


    public List<T> findAll();


}
