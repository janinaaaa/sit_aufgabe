package sit_aufgabe.service.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sit_aufgabe.dto.AddCategoryRequest;
import sit_aufgabe.dto.UpdateCategoryRequest;
import sit_aufgabe.mapper.CategoryMapper;
import sit_aufgabe.model.Category;
import sit_aufgabe.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category addCategory(AddCategoryRequest addCategoryRequest) {
        Category category = categoryMapper.toCategory(addCategoryRequest);
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Integer id) {
        Category category = categoryRepository.findById(id).get();
        categoryRepository.delete(category);
    }

    @Override
    public Category updateCategory(UpdateCategoryRequest updateCategoryRequest) {
        Category category = categoryMapper.toCategory(updateCategoryRequest);
        return categoryRepository.save(category);
    }
}
