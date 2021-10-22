package org.example.dao;

import java.io.Serializable;
import java.util.List;

public interface UserDaoInt<T, Id extends Serializable> {
    default void init() {

    }

    public void updateUser(T entity);

    public T findByIdUser(Id id);


    public List<T> findAllUsers();


}
