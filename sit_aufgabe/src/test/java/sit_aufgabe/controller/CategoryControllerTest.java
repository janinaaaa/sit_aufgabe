package sit_aufgabe.controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;

import sit_aufgabe.dto.UpdateCategoryRequest;
import sit_aufgabe.model.Category;
import sit_aufgabe.repository.CategoryRepository;
import sit_aufgabe.service.category.CategoryService;
import sit_aufgabe.dto.AddCategoryRequest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class CategoryControllerTest {
    @Mock
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;


    @InjectMocks
    private CustomerController customerController;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllCategoriesReturnsListOfCategories() throws Exception {
        List<Category> categories = List.of(new Category(1, "Category 1", "Description 1", 4), new Category(2, "Category 2", "Description 2", 5));
        when(categoryService.getAll()).thenReturn(categories);

        List<Category> foundCategories= categoryService.getAll();
        assertNotNull(foundCategories);
        assertEquals(2, foundCategories.size());
    }

    @Test
    void addCategoryReturnsCreatedCategory() throws Exception {
        AddCategoryRequest addCategoryRequest = new AddCategoryRequest("Category 1", "Description 1");
        Category category = new Category(1, "Category 1", "Description 1", 4);
        when(categoryService.addCategory(any(AddCategoryRequest.class))).thenReturn(category);

        categoryService.addCategory(addCategoryRequest);

        assertEquals(1, category.getId());
        assertEquals("Category 1", category.getName());

    }

    @Test
    void updateCategoryReturnsUpdatedCategory() throws Exception {
        UpdateCategoryRequest updateCategoryRequest = new UpdateCategoryRequest(1, "Updated Category", "Updated Description");
        Category category = new Category(1, "Updated Category", "Updated Description", 5);
        when(categoryService.updateCategory(any(UpdateCategoryRequest.class))).thenReturn(category);

        categoryService.updateCategory(updateCategoryRequest);
        assertEquals(1, category.getId());
        assertEquals("Updated Category", category.getName());
        assertEquals("Updated Description", category.getDescription());
    }

    @Test
    void deleteCategoryReturnsNoContent() throws Exception {
        doNothing().when(categoryService).deleteCategory(1);

        categoryService.deleteCategory(1);
    }


}