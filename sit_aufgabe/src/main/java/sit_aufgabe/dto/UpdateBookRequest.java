package sit_aufgabe.dto;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBookRequest {
    @NotNull(message = "Id should not be null")
    private Integer id;
    @NotBlank(message = "Title should not be blank")
    private String title;
    @NotBlank(message = "Author should not be blank")
    private String author;
    @NotBlank(message = "Publisher should not be blank")
    private String publisher;
    @NotNull(message = "Publishing Year should not be null")
    private Integer publishingYear;
    @NotNull(message = "Category should not be null")
    private Integer categoryId;
}
