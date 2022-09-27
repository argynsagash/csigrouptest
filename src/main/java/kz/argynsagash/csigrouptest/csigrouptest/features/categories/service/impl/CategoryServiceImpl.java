package kz.argynsagash.csigrouptest.csigrouptest.features.categories.service.impl;

import kz.argynsagash.csigrouptest.csigrouptest.features.categories.entities.CategoryEntity;
import kz.argynsagash.csigrouptest.csigrouptest.features.categories.error.CategoryNotFoundFailure;
import kz.argynsagash.csigrouptest.csigrouptest.features.categories.repo.CategoryRepo;
import kz.argynsagash.csigrouptest.csigrouptest.features.categories.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    @Override
    public void create(String title) {
        CategoryEntity category = new CategoryEntity();
        category.setTitle(title);
        categoryRepo.save(category);
    }

    @Override
    public List<CategoryEntity> getAll() {
        return categoryRepo.findAll();
    }

    @Override
    public void update(Long id, String title) {
        CategoryEntity category = categoryRepo.findById(id).orElseThrow(CategoryNotFoundFailure::new);
        category.setTitle(title);
        categoryRepo.save(category);

    }

    @Override
    public void remove(Long id) {
        categoryRepo.deleteById(id);

    }



}
