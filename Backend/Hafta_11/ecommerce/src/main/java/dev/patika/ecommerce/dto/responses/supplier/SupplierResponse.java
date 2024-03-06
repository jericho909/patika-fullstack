package dev.patika.ecommerce.dto.responses.supplier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierResponse {
    private int id;
    private String companyName;
}
