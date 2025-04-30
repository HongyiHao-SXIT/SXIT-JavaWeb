package com.example.dao;
import com.example.entities.ExampleEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class ExampleDao {
    @Autowired
    private SessionFactory sessionFactory;
    public void save(ExampleEntity entity) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entity);
    }
}