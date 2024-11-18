package com.afsal.project2_consumer.dao;


import com.afsal.project2_consumer.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao{

    @Autowired
    private SessionFactory sessionFactory;


    public Product save(Product product){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(product);
        transaction.commit();
        session.close();
        return product;
    }
}

