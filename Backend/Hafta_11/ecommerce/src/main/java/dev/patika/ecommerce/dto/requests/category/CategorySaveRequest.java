package dev.patika.ecommerce.dto.requests.category;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategorySaveRequest {
    @NotNull(message = "CATEGORY NAME CANNOT BE EMPTY")
    private String name;
}
