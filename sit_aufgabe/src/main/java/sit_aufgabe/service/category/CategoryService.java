package sit_aufgabe.service.category;

import sit_aufgabe.dto.AddCategoryRequest;
import sit_aufgabe.dto.UpdateCategoryRequest;
import sit_aufgabe.model.Category;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing categories.
 */
public interface CategoryService {

    /**
     * Retrieves all categories.
     *
     * @return a list of all categories
     */
    List<Category> getAll();

    /**
     * Retrieves a category by its ID.
     *
     * @param id the ID of the category to retrieve
     * @return an Optional containing the category if found, or empty if not found
     */
    Optional<Category> getCategoryById(Integer id);

    /**
     * Adds a new category.
     *
     * @param addCategoryRequest the category to add
     * @return the added category
     */
    Category addCategory(AddCategoryRequest addCategoryRequest);

    /**
     * Deletes a category by its ID.
     *
     * @param id the ID of the category to delete
     */
    void deleteCategory(Integer id);

    /**
     * Updates an existing category.
     *
     * @param updateCategoryRequest the category to update
     * @return the updated category
     */
    Category updateCategory(UpdateCategoryRequest updateCategoryRequest);

    /**
     * Calculates the count of categories.
     *
     * @param id the ID of the category
     * @return the count of categories
     */
    int calculateCategoryCount(Integer id);
}