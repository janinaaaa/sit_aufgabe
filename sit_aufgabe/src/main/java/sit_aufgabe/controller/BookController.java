package sit_aufgabe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sit_aufgabe.dto.AddBookRequest;
import sit_aufgabe.dto.UpdateBookRequest;
import sit_aufgabe.model.Book;
import sit_aufgabe.service.book.BookService;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing books.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    /**
     * Retrieves all books.
     *
     * @return a ResponseEntity containing a list of all books
     */
    @PreAuthorize("permitAll()")
    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    /**
     * Retrieves a book by its ID.
     *
     * @param id the ID of the book to retrieve
     * @return a ResponseEntity containing the book if found, or a 404 Not Found status if not found
     */
    @PreAuthorize("permitAll()")
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id){
        Optional<Book> book = bookService.getBookById(id);
        return book.isPresent() ? ResponseEntity.ok(book.get()) : ResponseEntity.notFound().build();
    }

    /**
     * Adds a new book.
     *
     * @param book the book to add
     * @return a ResponseEntity containing the added book and a 201 Created status
     */
    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody AddBookRequest book) {
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.CREATED);
    }

    /**
     * Updates an existing book.
     *
     * @param book the book to update
     * @return a ResponseEntity containing the updated book
     */
    @PutMapping("/update")
    public ResponseEntity<Book> updateBook(@RequestBody UpdateBookRequest book) {
        return ResponseEntity.ok(bookService.updateBook(book));
    }

    /**
     * Deletes a book by its ID.
     *
     * @param id the ID of the book to delete
     */
    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
    }
}