package kz.argynsagash.csigrouptest.csigrouptest.features.categories.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import kz.argynsagash.csigrouptest.csigrouptest.features.categories.entities.CategoryEntity;
import kz.argynsagash.csigrouptest.csigrouptest.features.categories.service.CategoryService;
import kz.argynsagash.csigrouptest.csigrouptest.features.details.entities.DetailEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/categories")
@Tag(name = "categories", description = "The Categories API")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/create/{categoryName}")
    public String create(@PathVariable String categoryName) {
        categoryService.create(categoryName);
        return "Category " + categoryName + " created";
    }

    @GetMapping
    public List<CategoryEntity> getAll() {
        return categoryService.getAll();
    }

    @PutMapping("/update")
    public String update(@RequestBody CategoryEntity category) {
        categoryService.update(category.getId(), category.getTitle());
        return "DONE";
    }

    @DeleteMapping("/delete/{categoryId}")
    public void delete(@PathVariable Long categoryId) {
        categoryService.remove(categoryId);
    }


}
