package dev.patika.library.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int id;

    @Column(name = "author_name")
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "author_birth_date")
    private LocalDate birthDate;

    @Column(name = "author_country")
    private String country;

    @OneToMany(mappedBy = "author")
    private List<Book> bookList;
}
