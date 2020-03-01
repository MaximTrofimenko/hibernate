package com.trofimenko;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
        Session session = null;

        session = factory.getCurrentSession();
        session.beginTransaction();
        //Customer customer = session.get(Customer.class, 4);
        Product product = session.get(Product.class,2);


        //System.out.println(customer);
        System.out.println(product);
        session.getTransaction().commit();

//        session = factory.getCurrentSession();
//        Customer cust = new Customer();
//        cust.setName("Человек Муравей");
//        session.beginTransaction();
//        session.save(cust);
//        session.getTransaction().commit();

//        session = factory.getCurrentSession();
//        session.beginTransaction();
//        Customer cust1 = session.get(Customer.class, 1);
//        session.delete(cust1);
//        session.getTransaction().commit();


//        session = factory.getCurrentSession();
//            session.beginTransaction();
//            Customer cust1 = session.get(Customer.class, 1);
//            cust1.setName("Железный человек");
//            session.getTransaction().commit();


        // это пример с использованием Entity Manager
        /*EntityManagerFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();
        EntityManager em = factory.createEntityManager();
        Customer cust = new Customer();
        cust.setName("чел");
        em.getTransaction().begin();
        em.persist(cust);
        em.getTransaction().commit();*/

//        session = factory.getCurrentSession();
//        session.beginTransaction();
//        List<Customer> customers = session.createQuery("from Customer c where c.id = 2").getResultList();
//        System.out.println(customers);
//        session.getTransaction().commit();
    }
}
