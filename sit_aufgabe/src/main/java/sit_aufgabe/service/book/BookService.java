package sit_aufgabe.service.book;

import sit_aufgabe.dto.AddBookRequest;
import sit_aufgabe.dto.UpdateBookRequest;
import sit_aufgabe.model.Book;


import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllBooks();
    Optional<Book> getBookById(Integer id);

    Book addBook(AddBookRequest book);
    void deleteBook(Integer id);
    Book updateBook(UpdateBookRequest updatedBook);

}
