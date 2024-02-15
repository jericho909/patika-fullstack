package dev.patika.ecommerce.dto.responses.product;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private int id;
    private String name;
    private double price;
    private int stock;
    private int supplierId;
    private int categoryId;
}
