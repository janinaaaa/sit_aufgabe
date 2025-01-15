package sit_aufgabe.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String author;
    private String publisher;
    // Could be restricted to 2025
    private int publishingYear;
    @ManyToOne
    @JoinColumn(name="category_id", referencedColumnName = "id")
    private Category category;

}