package sit_aufgabe.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sit_aufgabe.dto.AddCategoryRequest;
import sit_aufgabe.dto.UpdateCategoryRequest;
import sit_aufgabe.model.Category;
import sit_aufgabe.service.category.CategoryService;

import java.util.List;

/**
 * REST controller for managing categories.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    /**
     * Retrieves all categories.
     *
     * @return a ResponseEntity containing a list of all categories
     */
    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAllBooks(){
        return ResponseEntity.ok(categoryService.getAll());
    }

    /**
     * Adds a new category.
     *
     * @param category the category to add
     * @return a ResponseEntity containing the added category and a 201 Created status
     */
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/add")
    public ResponseEntity<Category> addBook(@Valid @RequestBody AddCategoryRequest category) {
        return new ResponseEntity<>(categoryService.addCategory(category), HttpStatus.CREATED);
    }

    /**
     * Updates an existing category.
     *
     * @param category the category to update
     * @return a ResponseEntity containing the updated category
     */
    @PreAuthorize("isAuthenticated()")
    @PutMapping("/update")
    public ResponseEntity<Category> updateBook(@Valid @RequestBody UpdateCategoryRequest category) {
        return ResponseEntity.ok(categoryService.updateCategory(category));
    }

    /**
     * Deletes a category by its ID.
     *
     * @param id the ID of the category to delete
     */
    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Integer id){
        categoryService.deleteCategory(id);
    }
}