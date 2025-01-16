package sit_aufgabe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit_aufgabe.model.Book;
import sit_aufgabe.model.Category;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing Book entities.
 */
public interface BookRepository extends JpaRepository<Book, Integer> {

    /**
     * Retrieves a book by its ID.
     *
     * @param id the ID of the book to retrieve
     * @return an Optional containing the book if found, or empty if not found
     */
    Optional<Book> getBookById(Integer id);

    /**
     * Retrieves books by their category.
     *
     * @param category the category of the books to retrieve
     * @return a list of books in the specified category
     */
    List<Book> getBookByCategory(Category category);
}