package sit_aufgabe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class representing a Category.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Category")
public class Category {

    /**
     * The unique identifier for the category.
     * Generated automatically.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * The name of the category.
     */
    private String name;

    /**
     * The description of the category.
     */
    private String description;

    /**
     * The number of books in the category.
     */
    private int numberOfBooks;
}