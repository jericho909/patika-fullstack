package dev.patika;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("market");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();



        transaction.begin();

//        Supplier supplier = new Supplier();
//        supplier.setAddress("test address");
//        supplier.setCompany("testC");
//        supplier.setContact("testContact");
//        supplier.setMail("test mail");
//        supplier.setPerson("test person");
//        entityManager.persist(supplier);

//        Category category = new Category();
//        category.setName("test cat");
//        entityManager.persist(category);

//        Customer c1 = new Customer();
//        c1.setOnDate(LocalDate.now());
//        c1.setName("Jane Doe");
//        c1.setMail("jane@doe.org");
//        c1.setGender(Customer.GENDER.FEMALE);
//        entityManager.persist(c1);
//
//        Customer customer = new Customer();
//        customer.setName("John Doe");
//        customer.setMail("john@doe.com");
//        customer.setGender(Customer.GENDER.MALE);
//        customer.setOnDate(LocalDate.now());
//        entityManager.persist(customer);


//        Code code = new Code();
//        code.setGroup("11123");
//        code.setSerial("4456");
//        entityManager.persist(code);
//
//        Product product = new Product();
//        product.setName("Test PRO2");
//        product.setPrice(1755.0);
//        product.setStock(200);
//        product.setCode(code);
//        product.setSupplier(supplier);
//        product.setCategory(category);
//        entityManager.persist(product);

//        Supplier supplier = entityManager.find(Supplier.class, 1);
//        Category category = entityManager.find(Category.class, 1);
//
//        Product product = new Product();
//        product.setName("Test PRO");
//        product.setPrice(1955.0);
//        product.setStock(100);
//        product.setCode(code);
//        product.setSupplier(supplier);
//        product.setCategory(category);
//        entityManager.persist(product);

//        Color blue = new Color();
//        blue.setName("blue");
//        Color red = new Color();
//        red.setName("red");
//        Color green = new Color();
//        green.setName("green");
//
//        entityManager.persist(blue);
//        entityManager.persist(red);
//        entityManager.persist(green);
//
//
//        List<Color> colorList = new ArrayList<>();
//        colorList.add(red);
//        colorList.add(blue);
//        product.setColorList(colorList);
//
//
//        entityManager.persist(product);
        


        transaction.commit();


//
//
//        //reading and updating from DB
//        Customer customer = entityManager.find(Customer.class, 1);
//        customer.setName("Jeffrey Doe");
//        transaction.begin();
//        entityManager.persist(customer);
//        transaction.commit();
//
//       //deleting from DB
//
//        Customer c1 = entityManager.find(Customer.class, 4);
//        transaction.begin();
//        entityManager.remove(c1);
//        transaction.commit();
//
//        transaction.commit();


    }
}
