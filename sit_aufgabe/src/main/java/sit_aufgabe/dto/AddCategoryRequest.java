package sit_aufgabe.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for adding a new category.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCategoryRequest {

    /**
     * The name of the category.
     * Must not be blank.
     */
    @NotBlank(message = "Name should not be blank")
    private String name;

    /**
     * The description of the category.
     * Must not be blank.
     */
    @NotBlank(message = "Description should not be blanl")
    private String description;
}