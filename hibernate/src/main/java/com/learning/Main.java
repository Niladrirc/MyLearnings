package com.learning;


import com.learning.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.imageio.spi.ServiceRegistry;

@Slf4j
public class Main {
    public static void main(String[] args) {

        Dish biryani = new Dish();
        biryani.setName("Biryani");
        biryani.setPrice(120.00D);
        try {
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml")
                    .build();
            MetadataSources sources = new MetadataSources(serviceRegistry);

            Metadata metadata = sources.buildMetadata();
            SessionFactory sessionFactory = metadata.buildSessionFactory();

            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(biryani);

            transaction.commit();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}