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

@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAllBooks(){
        return ResponseEntity.ok(categoryService.getAll());
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/add")
    public ResponseEntity<Category> addBook(@Valid @RequestBody AddCategoryRequest category) {
        return new ResponseEntity<>(categoryService.addCategory(category), HttpStatus.CREATED);
    }

    @PreAuthorize("isAuthenticated()")
    @PutMapping("/update")
    public ResponseEntity<Category> updateBook(@Valid @RequestBody UpdateCategoryRequest category) {
        return ResponseEntity.ok(categoryService.updateCategory(category));
    }

    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Integer id){
        categoryService.deleteCategory(id);
    }
}
