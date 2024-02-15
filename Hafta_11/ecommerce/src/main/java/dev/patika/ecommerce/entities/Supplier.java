package dev.patika.ecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "suppliers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id", columnDefinition = "serial")
    private int id;

    @Column(name = "supplier_name")
    private String name;

    @Column(name = "supplier_contact")
    private String contactName;

    @Column(name = "supplier_address")
    private String address;

    @Column(name = "supplier_mail")
    private String mail;

    @OneToMany(mappedBy = "supplier")
    private List<Product> products;
}
