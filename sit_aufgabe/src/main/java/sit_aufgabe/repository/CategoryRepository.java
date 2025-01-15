package sit_aufgabe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit_aufgabe.model.Category;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findById(Integer id);
}
