package kz.argynsagash.csigrouptest.csigrouptest.features.details.service.impl;

import kz.argynsagash.csigrouptest.csigrouptest.features.categories.entities.CategoryEntity;
import kz.argynsagash.csigrouptest.csigrouptest.features.categories.error.CategoryNotFoundFailure;
import kz.argynsagash.csigrouptest.csigrouptest.features.categories.repo.CategoryRepo;
import kz.argynsagash.csigrouptest.csigrouptest.features.details.entities.DetailEntity;
import kz.argynsagash.csigrouptest.csigrouptest.features.details.error.DetailNotFoundFailure;
import kz.argynsagash.csigrouptest.csigrouptest.features.details.repo.DetailRepo;
import kz.argynsagash.csigrouptest.csigrouptest.features.details.service.DetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DetailServiceImpl implements DetailService {

    private final DetailRepo detailRepo;
    private final CategoryRepo categoryRepo;

    @Override
    public void create(String title, Double price, Long categoryId) {
        CategoryEntity category = categoryRepo.findById(categoryId).orElseThrow(CategoryNotFoundFailure::new);
        DetailEntity detail = DetailEntity.builder().
                title(title).
                price(price).
                build();
        category.setPrice(category.getPrice() + price);
        detail.setCategoryEntity(category);
        detailRepo.save(detail);
    }

    @Override
    public List<DetailEntity> getAll() {
        return detailRepo.findAll();
    }

    @Override
    public void update(Long id, String title, Double price) {
        DetailEntity detail = detailRepo.findById(id).orElseThrow(DetailNotFoundFailure::new);
        detail.setTitle(title);
        detail.setPrice(price);
        detailRepo.save(detail);
    }

    @Override
    public void remove(Long id) {
        detailRepo.deleteById(id);
    }

}
