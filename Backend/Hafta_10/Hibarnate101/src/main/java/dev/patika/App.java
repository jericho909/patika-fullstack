package dev.patika;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
            SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Customer.class)
                    .buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            try{
                Customer customer = new Customer();
//                customer.setName("John Doe");
//                customer.setGender(Customer.GENDER.FEMALE);
//                customer.setOnDate(LocalDate.now());
//                customer.setMail("test@test");
//
//                session.persist(customer);
//                customer = session.get(Customer.class, 1);
//                System.out.println(customer.toString());

                List<Customer> customers = session.createSelectionQuery("FROM Customer", Customer.class).getResultList();

                for (Customer customer1: customers){
                    System.out.println(customer1.getGender().toString());
                }
                
                session.getTransaction().commit();
            } catch (Exception e){
                session.getTransaction().rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
        }

}