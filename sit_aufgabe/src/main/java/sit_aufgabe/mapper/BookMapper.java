package sit_aufgabe.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sit_aufgabe.dto.AddBookRequest;
import sit_aufgabe.dto.UpdateBookRequest;
import sit_aufgabe.model.Book;
import sit_aufgabe.repository.CategoryRepository;

/**
 * Mapper class for converting between Book entities and DTOs.
 */
@Component
@RequiredArgsConstructor
public class BookMapper {
    private final CategoryRepository categoryRepository;

    /**
     * Converts an AddBookRequest DTO to a Book entity.
     *
     * @param addBookRequest the AddBookRequest DTO
     * @return the Book entity
     */
    public Book toBook(AddBookRequest addBookRequest){
        Book book = new Book();
        book.setTitle(addBookRequest.getTitle());
        book.setAuthor(addBookRequest.getAuthor());
        book.setPublisher(addBookRequest.getPublisher());
        book.setPublishingYear(addBookRequest.getPublishingYear());
        book.setCategory(categoryRepository.findById(addBookRequest.getCategoryId()).get());
        return book;
    }

    /**
     * Converts an UpdateBookRequest DTO to a Book entity.
     *
     * @param updateBookRequest the UpdateBookRequest DTO
     * @return the Book entity
     */
    public Book toBook(UpdateBookRequest updateBookRequest){
        Book book = new Book();
        book.setId(updateBookRequest.getId());
        book.setTitle(updateBookRequest.getTitle());
        book.setAuthor(updateBookRequest.getAuthor());
        book.setPublisher(updateBookRequest.getPublisher());
        book.setPublishingYear(updateBookRequest.getPublishingYear());
        book.setCategory(categoryRepository.findById(updateBookRequest.getCategoryId()).get());
        return book;
    }

    /**
     * Converts a Book entity to an AddBookRequest DTO.
     *
     * @param book the Book entity
     * @return the AddBookRequest DTO
     */
    public AddBookRequest toAddBookRequest(Book book){
        AddBookRequest addBookRequest = new AddBookRequest();
        addBookRequest.setTitle(book.getTitle());
        addBookRequest.setAuthor(book.getAuthor());
        addBookRequest.setPublisher(book.getPublisher());
        addBookRequest.setPublishingYear(book.getPublishingYear());
        addBookRequest.setCategoryId(book.getCategory().getId());
        return addBookRequest;
    }

    /**
     * Converts a Book entity to an UpdateBookRequest DTO.
     *
     * @param book the Book entity
     * @return the UpdateBookRequest DTO
     */
    public UpdateBookRequest toUpdateBookRequest(Book book){
        UpdateBookRequest updateBookRequest = new UpdateBookRequest();
        updateBookRequest.setTitle(book.getTitle());
        updateBookRequest.setAuthor(book.getAuthor());
        updateBookRequest.setPublisher(book.getPublisher());
        updateBookRequest.setPublishingYear(book.getPublishingYear());
        updateBookRequest.setCategoryId(book.getCategory().getId());
        return updateBookRequest;
    }
}