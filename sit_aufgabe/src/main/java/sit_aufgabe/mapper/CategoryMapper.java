package sit_aufgabe.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sit_aufgabe.dto.AddCategoryRequest;
import sit_aufgabe.dto.UpdateCategoryRequest;
import sit_aufgabe.model.Category;
import sit_aufgabe.repository.BookRepository;
import sit_aufgabe.repository.CategoryRepository;

/**
 * Mapper class for converting between Category entities and DTOs.
 */
@Component
@RequiredArgsConstructor
public class CategoryMapper {

    /**
     * Converts an AddCategoryRequest DTO to a Category entity.
     *
     * @param addCategoryRequest the AddCategoryRequest DTO
     * @return the Category entity
     */
    public Category toCategory(AddCategoryRequest addCategoryRequest){
        Category category = new Category();
        category.setName(addCategoryRequest.getName());
        category.setDescription(addCategoryRequest.getDescription());
        return category;
    }

    /**
     * Converts an UpdateCategoryRequest DTO to a Category entity.
     *
     * @param updateCategoryRequest the UpdateCategoryRequest DTO
     * @return the Category entity
     */
    public Category toCategory(UpdateCategoryRequest updateCategoryRequest){
        Category category = new Category();
        category.setId(updateCategoryRequest.getId());
        category.setName(updateCategoryRequest.getName());
        category.setDescription(updateCategoryRequest.getDescription());
        return category;
    }

    /**
     * Converts a Category entity to an AddCategoryRequest DTO.
     *
     * @param category the Category entity
     * @return the AddCategoryRequest DTO
     */
    public AddCategoryRequest toAddCategoryRequest(Category category){
        AddCategoryRequest addCategoryRequest = new AddCategoryRequest();
        addCategoryRequest.setName(category.getName());
        addCategoryRequest.setDescription(category.getDescription());
        return addCategoryRequest;
    }

    /**
     * Converts a Category entity to an UpdateCategoryRequest DTO.
     *
     * @param category the Category entity
     * @return the UpdateCategoryRequest DTO
     */
    public UpdateCategoryRequest toUpdateCategoryRequest(Category category){
        UpdateCategoryRequest updateCategoryRequest = new UpdateCategoryRequest();
        updateCategoryRequest.setId(category.getId());
        updateCategoryRequest.setName(category.getName());
        updateCategoryRequest.setDescription(category.getDescription());
        return updateCategoryRequest;
    }
}