package dev.patika;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", columnDefinition = "serial")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "publication_year")
    private String year;

    @Column(name = "stock")
    private int stock;

    @ManyToOne
    @JoinColumn(name = "book_author", referencedColumnName = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "book_publisher", referencedColumnName = "publisher_id")
    private Publisher publisher;

    @OneToMany(mappedBy = "book")
    private ArrayList<BookBorrowing> bookBorrowings;

    @ManyToMany
    @JoinTable(name = "cat2books", joinColumns = {@JoinColumn(name = "cat2book_category_id")}, inverseJoinColumns = {@JoinColumn(name = "cat2book_book_id")})
    private List<Category> bookCategories;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public ArrayList<BookBorrowing> getBookBorrowings() {
        return bookBorrowings;
    }

    public void setBookBorrowings(ArrayList<BookBorrowing> bookBorrowings) {
        this.bookBorrowings = bookBorrowings;
    }

    public List<Category> getBookCategories() {
        return bookCategories;
    }

    public void setBookCategories(List<Category> bookCategories) {
        this.bookCategories = bookCategories;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", stock=" + stock +
                ", author=" + author +
                ", publisher=" + publisher +
                '}';
    }
}
