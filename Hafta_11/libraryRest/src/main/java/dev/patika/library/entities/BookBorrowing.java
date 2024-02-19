package dev.patika.library.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "book_borrowings")
public class BookBorrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;

    @Column(name = "borrower_name")
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "borrowing_date")
    private LocalDate borrow_date;

    @Temporal(TemporalType.DATE)
    @Column(name = "return_date")
    private LocalDate return_date;

    @ManyToOne
    @JoinColumn(name = "borrowed_book", referencedColumnName = "book_id")
    private Book book;
}
