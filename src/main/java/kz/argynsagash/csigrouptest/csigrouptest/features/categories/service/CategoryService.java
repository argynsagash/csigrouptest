package kz.argynsagash.csigrouptest.csigrouptest.features.categories.service;

import kz.argynsagash.csigrouptest.csigrouptest.features.categories.entities.CategoryEntity;
import java.util.List;

public interface CategoryService {
    void create(String title);
    List<CategoryEntity> getAll();
    void update(Long id, String title);
    void remove(Long id);
    CategoryEntity getById(Long id);


}
