package org.example.dao;

import org.example.models.UserModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UserDao implements UserDaoInt<UserModel, Integer> {
    private Session currentSession;
    private Transaction currentTransaction;
    private SessionFactory sessionFactory;

    public UserDao() {
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
    public void updateUser(UserModel entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public UserModel findByIdUser(Integer id) {

        sessionFactory = getSessionFactory();
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        UserModel user = (UserModel) session.get(UserModel.class, id);

        tx.commit();

        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<UserModel> findAllUsers() {
        sessionFactory = getSessionFactory();
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();


        List<UserModel> users = (List<UserModel>) session.createQuery("FROM UserModel").list();
        tx.commit();
        session.close();
        return users;
    }


}
