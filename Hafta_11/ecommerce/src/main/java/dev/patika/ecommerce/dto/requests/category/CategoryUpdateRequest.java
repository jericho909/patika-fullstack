package dev.patika.ecommerce.dto.requests.category;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryUpdateRequest {
    @Positive(message = "ID VALUE CANNOT BE NEGATIVE")
    private int id;
    @NotNull(message = "CATEGORY NAME CANNOT BE EMPTY")
    private String name;
}
