package sit_aufgabe.mapper;

import org.springframework.stereotype.Component;
import sit_aufgabe.dto.AddCategoryRequest;
import sit_aufgabe.dto.UpdateCategoryRequest;
import sit_aufgabe.model.Category;

@Component
public class CategoryMapper {
    public Category toCategory(AddCategoryRequest addCategoryRequest){
        Category category = new Category();
        category.setName(addCategoryRequest.getName());
        category.setDescription(addCategoryRequest.getDescription());
        return category;
    }

    public Category toCategory(UpdateCategoryRequest updateCategoryRequest){
        Category category = new Category();
        category.setId(category.getId());
        category.setName(updateCategoryRequest.getName());
        category.setDescription(updateCategoryRequest.getDescription());
        return category;
    }

    public AddCategoryRequest toAddCategoryRequest(Category category){
        AddCategoryRequest addCategoryRequest = new AddCategoryRequest();
        addCategoryRequest.setName(category.getName());
        addCategoryRequest.setDescription(category.getDescription());
        return addCategoryRequest;
    }

    public UpdateCategoryRequest toUpdateCategoryRequest(Category category){
        UpdateCategoryRequest updateCategoryRequest = new UpdateCategoryRequest();
        updateCategoryRequest.setId(category.getId());
        updateCategoryRequest.setName(category.getName());
        updateCategoryRequest.setDescription(category.getDescription());
        return updateCategoryRequest;
    }
}
