package dev.patika.library.dto.requests.author;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorSaveRequest {
    @NotNull(message = "AUTHOR NAME CANNOT BE EMPTY")
    private String name;
    private LocalDate birthDate;
    private String country;

}
