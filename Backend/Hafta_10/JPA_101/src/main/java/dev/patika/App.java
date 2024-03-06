package dev.patika;

import jakarta.persistence.*;
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

        //Query getAllCategories = entityManager.createQuery("SELECT cat FROM Category cat");
        TypedQuery<Category> getAllCategories = entityManager.createQuery("SELECT cat FROM Category cat WHERE cat.id = :id", Category.class);
        getAllCategories.setParameter("id", 3);
//        List<Category> categoryList = getAllCategories.getResultList();
//
//        for (Category category: categoryList){
//            System.out.println(category.getName());
//        }
//        Category category = getAllCategories.getSingleResult();
//        System.out.println(category.getName());

        TypedQuery<CheapProduct> getProd = entityManager.createQuery("SELECT NEW CheapProduct(p.id, p.name, p.price) FROM Product p WHERE p.price < 1800", CheapProduct.class);
        List<CheapProduct> cheapProductList = getProd.getResultList();

        for (CheapProduct cheapProduct: cheapProductList){
            System.out.println(cheapProduct.toString());
        }


        transaction.commit();

    }
}
