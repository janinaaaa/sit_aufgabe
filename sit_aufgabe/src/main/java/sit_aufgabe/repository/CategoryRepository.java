package sit_aufgabe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit_aufgabe.model.Category;

import java.util.Optional;

/**
 * Repository interface for managing Category entities.
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    /**
     * Retrieves a category by its ID.
     *
     * @param id the ID of the category to retrieve
     * @return an Optional containing the category if found, or empty if not found
     */
    Optional<Category> findById(Integer id);
}