package sit_aufgabe.service.book;

import sit_aufgabe.dto.AddBookRequest;
import sit_aufgabe.dto.UpdateBookRequest;
import sit_aufgabe.model.Book;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing books.
 */
public interface BookService {

    /**
     * Retrieves all books.
     *
     * @return a list of all books
     */
    List<Book> getAllBooks();

    /**
     * Retrieves a book by its ID.
     *
     * @param id the ID of the book to retrieve
     * @return an Optional containing the book if found, or empty if not found
     */
    Optional<Book> getBookById(Integer id);

    /**
     * Adds a new book.
     *
     * @param book the book to add
     * @return the added book
     */
    Book addBook(AddBookRequest book);

    /**
     * Deletes a book by its ID.
     *
     * @param id the ID of the book to delete
     */
    void deleteBook(Integer id);

    /**
     * Updates an existing book.
     *
     * @param updatedBook the book to update
     * @return the updated book
     */
    Book updateBook(UpdateBookRequest updatedBook);
}