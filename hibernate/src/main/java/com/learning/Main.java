package com.learning;


import com.learning.entity.Dish;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@Slf4j
public class Main {
    public static void main(String[] args) {

        Dish biryani = new Dish();
        biryani.setName("Biryani");
        biryani.setPrice(120.00D);

        Configuration config = new Configuration().configure("hibernate.cfg.xml");

        try (SessionFactory sessionFactory = config.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            try {
                Dish dish = session.get(Dish.class, 1);
                System.out.println(dish);
                transaction.commit();
            } catch (Exception e) {
                log.error("Error while inserting", e);
                transaction.rollback();
            }

        }
    }
}