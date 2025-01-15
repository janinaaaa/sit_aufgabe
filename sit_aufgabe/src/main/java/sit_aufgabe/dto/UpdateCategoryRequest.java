package sit_aufgabe.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryRequest {
    @NotNull(message = "Id should not be null")
    private Integer id;
    @NotBlank(message = "Name should not be null")
    private String name;
    @NotBlank(message = "Description should not be null")
    private String description;
}
