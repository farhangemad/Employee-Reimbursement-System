package com.back.services;

import com.back.dao.UserDao;
import com.back.models.UserModel;

import java.util.List;

public class UserService {

    private static UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public void persist(UserModel entity) {
        userDao.openCurrentSessionwithTransaction();
        userDao.persist(entity);
        userDao.closeCurrentSessionwithTransaction();
    }

    public void update(UserModel entity) {
        userDao.openCurrentSessionwithTransaction();
        userDao.update(entity);
        userDao.closeCurrentSessionwithTransaction();
    }

    public UserModel findById(Integer id) {
        userDao.openCurrentSession();
        UserModel book = userDao.findById(id);
        userDao.closeCurrentSession();
        return book;
    }

    public void delete(Integer id) {
        userDao.openCurrentSessionwithTransaction();
        UserModel book = userDao.findById(id);
        userDao.delete(book);
        userDao.closeCurrentSessionwithTransaction();
    }

    public List<UserModel> findAll() {
        userDao.openCurrentSession();
        List<UserModel> books = userDao.findAll();
        userDao.closeCurrentSession();
        return books;
    }

    public void deleteAll() {
        userDao.openCurrentSessionwithTransaction();
        userDao.deleteAll();
        userDao.closeCurrentSessionwithTransaction();
    }

    public UserDao bookDao() {
        return userDao;
    }

}
