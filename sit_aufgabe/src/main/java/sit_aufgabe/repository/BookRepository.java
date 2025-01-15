package sit_aufgabe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit_aufgabe.model.Book;
import sit_aufgabe.model.Category;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> getBookById(Integer id);
    List<Book> getBookByCategory(Category category);

}
