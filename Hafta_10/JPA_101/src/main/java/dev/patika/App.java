package dev.patika;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transaction;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("market");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


        //saving values in DB
//        transaction.begin();
//
//        Customer c1 = new Customer();
//        c1.setOnDate(LocalDate.now());
//        c1.setName("Jane Doe");
//        c1.setMail("jane@doe.org");
//        c1.setGender(Customer.GENDER.FEMALE);
//
//        entityManager.persist(c1);
//        transaction.commit();
//
//
//        transaction.begin();
//        Customer customer = new Customer();
//        customer.setName("John Doe");
//        customer.setMail("john@doe.com");
//        customer.setGender(Customer.GENDER.MALE);
//        customer.setOnDate(LocalDate.now());
//
//        entityManager.persist(customer);
//
//        transaction.commit();


        //reading and updating from DB
        Customer customer = entityManager.find(Customer.class, 1);
        customer.setName("Jeffrey Doe");
        transaction.begin();
        entityManager.persist(customer);
        transaction.commit();

       //deleting from DB

        Customer c1 = entityManager.find(Customer.class, 4);
        transaction.begin();
        entityManager.remove(c1);
        transaction.commit();

    }
}
