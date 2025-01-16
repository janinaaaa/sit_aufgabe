package sit_aufgabe.controller;

import jakarta.validation.Valid;
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

@RequiredArgsConstructor
@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;
    @PreAuthorize("permitAll()")
    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id){
        Optional<Book> book = bookService.getBookById(id);
        return book.isPresent() ? ResponseEntity.ok(book.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody AddBookRequest book) {
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<Book> updateBook(@RequestBody UpdateBookRequest book) {
        return ResponseEntity.ok(bookService.updateBook(book));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
    }

}
