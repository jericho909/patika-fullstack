package dev.patika.spring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", columnDefinition = "serial", length = 10)
    private int id;
    
    @Column(name = "customer_name", nullable = false, length = 20)
    private String name;
    
    @Column(name = "customer_mail", nullable = false, unique = true)
    private String mail;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "customer_on_date")
    private LocalDate onDate;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "customer_gender")
    private GENDER gender;

    public enum GENDER{
        MALE,
        FEMALE
    }

}
