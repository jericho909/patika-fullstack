package dev.patika.ecommerce.dto.requests.product;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSaveRequest {
    @NotNull(message = "PRODUCT NAME CANNOT BE EMPTY")
    private String name;
    private double price;
    private int stock;
    private int supplierId;
    private int categoryId;
}
