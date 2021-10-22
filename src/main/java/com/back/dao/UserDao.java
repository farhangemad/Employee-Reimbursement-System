package com.back.dao;

import com.back.models.UserModel;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;



public class UserDao implements Dao<UserModel, Integer> {

    private Session currentSession;

    private Transaction currentTransaction;



    public UserDao() {
    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }


    private SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();

        if(configuration != null) {
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
            return sessionFactory;
        } else {
            return null;
        }
    }
    /*private static SessionFactory getSessionFactory() {

        // A SessionFactory is set up once for an application
        Configuration conf = new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder builder = new
                StandardServiceRegistryBuilder().applySettings(conf.getProperties());
        SessionFactory factory = conf.buildSessionFactory(builder.build());
        return factory;

    }*/

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    @Override
    public void persist(UserModel entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(UserModel entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public UserModel findById(Integer id) {
        UserModel user = (UserModel) getCurrentSession().get(UserModel.class, id);
        return user;
    }

    @Override
    public void delete(UserModel entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<UserModel> findAll() {
        List<UserModel> users = (List<UserModel>) getCurrentSession().createQuery("from users").list();
        return users;
    }

    @Override
    public void deleteAll() {
        List<UserModel> entityList = findAll();
        for (UserModel entity : entityList) {
            delete(entity);
        }
    }
}
