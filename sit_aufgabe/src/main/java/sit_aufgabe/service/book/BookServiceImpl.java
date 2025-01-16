package sit_aufgabe.service.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sit_aufgabe.dto.AddBookRequest;
import sit_aufgabe.dto.UpdateBookRequest;
import sit_aufgabe.mapper.BookMapper;
import sit_aufgabe.model.Book;
import sit_aufgabe.repository.BookRepository;
import sit_aufgabe.service.category.CategoryService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final CategoryService categoryService;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Integer id) {
        return bookRepository.getBookById(id);
    }

    @Override
    public Book addBook(AddBookRequest addBookRequest) {
        Book book = bookMapper.toBook(addBookRequest);
        book.getCategory().setNumberOfBooks(categoryService.calculateCategoryCount(book.getCategory().getId()));
        return bookRepository.save(book);

    }

    @Override
    public void deleteBook(Integer id) {
        Book deleteBook = bookRepository.getBookById(id).get();
        bookRepository.delete(deleteBook);
    }

    @Override
    public Book updateBook(UpdateBookRequest updatedBook) {
        Book book = bookMapper.toBook(updatedBook);
        book.getCategory().setNumberOfBooks(categoryService.calculateCategoryCount(book.getCategory().getId()));
        return bookRepository.save(book);
    }
}
