package org.example.dao;

import org.example.models.RequestModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RequestDao implements Dao<RequestModel, Integer> {
    private Session currentSession;
    private Transaction currentTransaction;
    private SessionFactory sessionFactory;

    public RequestDao() {
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
    public void persist(RequestModel entity) {
        sessionFactory = getSessionFactory();
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(entity);
        tx.commit();
    }


    @Override
    public RequestModel findById(Integer id) {

        sessionFactory = getSessionFactory();
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        RequestModel user = (RequestModel) session.get(RequestModel.class, id);

        tx.commit();

        return user;
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<RequestModel> findAll() {
        sessionFactory = getSessionFactory();
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();


        List<RequestModel> users = (List<RequestModel>) session.createQuery("FROM RequestModel").list();
        tx.commit();
        session.close();
        return users;
    }


}
