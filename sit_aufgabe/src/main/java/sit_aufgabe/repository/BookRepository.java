package sit_aufgabe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit_aufgabe.model.Book;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> getBookById(Integer id);

}
