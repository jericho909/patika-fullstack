package dev.patika;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        Author author = new Author();
        author.setName("J.R.R. Tolkien");
        author.setCountry("United Kingdom");
        author.setBirthDate(LocalDate.of(1982, 1, 3));
        entityManager.persist(author);

        Publisher publisher = new Publisher();
        publisher.setName("Ithaki");
        publisher.setAddress("test address");
        publisher.setYear(1982);
        entityManager.persist(publisher);

        Category adventure = new Category();
        adventure.setName("adventure");
        Category fantasy = new Category();
        fantasy.setName("fantasy");
        Category horror = new Category();
        horror.setName("horror");
        entityManager.persist(adventure);
        entityManager.persist(fantasy);
        entityManager.persist(horror);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(adventure);
        categoryList.add(fantasy);

        Book book1 = new Book();
        book1.setName("Lord of The Rings: Fellowship of the Ring");
        book1.setAuthor(author);
        book1.setPublisher(publisher);
        book1.setBookCategories(categoryList);
        book1.setYear("1960");
        book1.setStock(100);
        entityManager.persist(book1);

        BookBorrowing borrow1 = new BookBorrowing();
        borrow1.setName("Jack Doe");
        borrow1.setBook(book1);
        borrow1.setBorrow_date(LocalDate.now());
        borrow1.setReturn_date(null);
        entityManager.persist(borrow1);


        transaction.commit();
    }

}