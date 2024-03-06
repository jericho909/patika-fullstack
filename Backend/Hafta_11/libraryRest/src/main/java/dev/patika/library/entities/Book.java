package dev.patika.library.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", columnDefinition = "serial")
    private int id;

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
}
