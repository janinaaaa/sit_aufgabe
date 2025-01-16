package sit_aufgabe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class representing a Book.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Book")
public class Book {

    /**
     * The unique identifier for the book.
     * Generated automatically.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * The title of the book.
     */
    private String title;

    /**
     * The author of the book.
     */
    private String author;

    /**
     * The publisher of the book.
     */
    private String publisher;

    /**
     * The publishing year of the book.
     * Could be restricted to 2025.
     */
    private int publishingYear;

    /**
     * The category the book belongs to.
     * Many-to-one relationship with the Category entity.
     */
    @ManyToOne
    @JoinColumn(name="category_id", referencedColumnName = "id")
    private Category category;
}