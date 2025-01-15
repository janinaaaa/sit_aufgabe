package sit_aufgabe.service.category;

import sit_aufgabe.dto.AddCategoryRequest;
import sit_aufgabe.dto.UpdateCategoryRequest;
import sit_aufgabe.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getCategories();
    Optional<Category> getCategoryById(Integer id);
    Category addCategory(AddCategoryRequest addCategoryRequest);
    void deleteCategory(Integer id);
    Category updateCategory(UpdateCategoryRequest updateCategoryRequest);

}
