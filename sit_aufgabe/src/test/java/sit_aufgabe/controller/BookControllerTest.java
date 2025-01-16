package sit_aufgabe.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import sit_aufgabe.dto.AddBookRequest;
import sit_aufgabe.dto.UpdateBookRequest;
import sit_aufgabe.model.Book;
import sit_aufgabe.model.Category;
import sit_aufgabe.service.book.BookService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
class BookControllerTest {



    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private BookService bookService;



    @InjectMocks
    private BookController bookController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllBooksReturnsListOfBooks() throws Exception {
        Category category = new Category(1, "Category 1", "test", 4);
        List<Book> books = List.of(new Book(1, "Book 1", "Author 1", "Springer", 2005, category), new Book(2, "Book 2", "Author 2", "Springer", 2005, category));
        when(bookService.getAllBooks()).thenReturn(books);

        List<Book> foundBooks = bookService.getAllBooks();

        assertNotNull(foundBooks);
        assertEquals(2, foundBooks.size());



    }

    @Test
    void getBookByIdReturnsBook() throws Exception {
        Category category = new Category(1, "Category 1", "test", 4);
        Book book = new Book(1, "Book 1", "Author 1", "Springer", 2005, category);
        when(bookService.getBookById(1)).thenReturn(Optional.of(book));

        Book foundBook = bookService.getBookById(1).get();
        assertEquals(1, foundBook.getId());
        assertNotNull(foundBook);
    }

    @Test
    void getBookByIdReturnsNotFound() throws Exception {
        when(bookService.getBookById(1)).thenReturn(Optional.empty());

        Optional<Book> foundBook = bookService.getBookById(1);

        assertEquals(Optional.empty(), foundBook);
    }

    @Test
    void addBookReturnsCreatedBook() throws Exception {
        Category category = new Category(1, "Category 1", "test", 4);
        AddBookRequest addBookRequest = new AddBookRequest("Book 1", "Author 1", "Springer", 2005, 1);
        Book book = new Book(1, "Book 1", "Author 1", "Springer", 2005, category);
        when(bookService.addBook(any(AddBookRequest.class))).thenReturn(book);

        Book addedBook = bookService.addBook(addBookRequest);
        assertEquals(1, book.getId());
        assertEquals("Book 1", book.getTitle());
        assertEquals("Author 1", book.getAuthor());

    }

    @Test
    void updateBookReturnsUpdatedBook() throws Exception {
        Category category = new Category(1, "Category 1", "test", 4);
        UpdateBookRequest updateBookRequest = new UpdateBookRequest(1, "Updated Book", "Updated Author", "Springer", 2005, 1);
        Book book = new Book(1, "Updated Book", "Updated Author", "Springer", 2005, category);
        when(bookService.updateBook(any(UpdateBookRequest.class))).thenReturn(book);

        Book updatedBook = bookService.updateBook(updateBookRequest);
        assertEquals(1, book.getId());
        assertEquals("Updated Book", book.getTitle());
        assertEquals("Updated Author", book.getAuthor());

    }

    @Test
    void deleteBookReturnsNoContent() throws Exception {
        doNothing().when(bookService).deleteBook(1);

        bookService.deleteBook(1);

    }
}