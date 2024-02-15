package dev.patika.ecommerce.dto.requests.supplier;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierSaveRequest {
    @NotNull(message = "COMPANY NAME CANNOT BE EMPTY")
    private String name;
    private String contactName;
    private String address;
    @Email
    private String mail;
}
