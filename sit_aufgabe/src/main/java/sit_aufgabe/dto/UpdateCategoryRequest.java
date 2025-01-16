package sit_aufgabe.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for updating an existing category.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryRequest {

    /**
     * The ID of the category.
     * Must not be null.
     */
    @NotNull(message = "Id should not be null")
    private Integer id;

    /**
     * The name of the category.
     * Must not be blank.
     */
    @NotBlank(message = "Name should not be null")
    private String name;

    /**
     * The description of the category.
     * Must not be blank.
     */
    @NotBlank(message = "Description should not be null")
    private String description;
}