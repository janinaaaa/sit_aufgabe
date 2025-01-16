package sit_aufgabe.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for adding a new book.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBookRequest {

    /**
     * The title of the book.
     * Must not be blank.
     */
    @NotBlank(message = "Title should not be blank")
    private String title;

    /**
     * The author of the book.
     * Must not be blank.
     */
    @NotBlank(message = "Author should not be blank")
    private String author;

    /**
     * The publisher of the book.
     * Must not be blank.
     */
    @NotBlank(message = "Publisher should not be blank")
    private String publisher;

    /**
     * The publishing year of the book.
     * Must not be null.
     */
    @NotNull(message = "Publishing Year should not be null")
    private Integer publishingYear;

    /**
     * The ID of the category the book belongs to.
     * Must not be null.
     */
    @NotNull(message = "Category should not be null")
    private Integer categoryId;
}