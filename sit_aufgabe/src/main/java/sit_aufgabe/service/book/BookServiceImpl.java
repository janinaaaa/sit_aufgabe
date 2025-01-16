package sit_aufgabe.service.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sit_aufgabe.dto.AddBookRequest;
import sit_aufgabe.dto.UpdateBookRequest;
import sit_aufgabe.mapper.BookMapper;
import sit_aufgabe.mapper.CategoryMapper;
import sit_aufgabe.model.Book;
import sit_aufgabe.model.Category;
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
    private final CategoryMapper categoryMapper;

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
        Category updateCategory = book.getCategory();
        Book updateBook = bookRepository.save(book);
        updateCategory.setNumberOfBooks(categoryService.calculateCategoryCount(book.getCategory().getId()));
        Category category = categoryService.updateCategory(categoryMapper.toUpdateCategoryRequest(updateCategory));
        updateBook.setCategory(category);
        return bookRepository.save(updateBook);

    }

    @Override
    public void deleteBook(Integer id) {
        Book deleteBook = bookRepository.getBookById(id).get();
        bookRepository.delete(deleteBook);
    }

    @Override
    public Book updateBook(UpdateBookRequest updatedBook) {
        Book book = bookMapper.toBook(updatedBook);
        Category updateCategory = book.getCategory();
        Book updateBook = bookRepository.save(book);
        book.getCategory().setNumberOfBooks(categoryService.calculateCategoryCount(book.getCategory().getId()));
        updateCategory.setNumberOfBooks(categoryService.calculateCategoryCount(book.getCategory().getId()));
        Category category = categoryService.updateCategory(categoryMapper.toUpdateCategoryRequest(updateCategory));
        updateBook.setCategory(category);
        return bookRepository.save(book);
    }
}
