package kz.argynsagash.csigrouptest.csigrouptest.features.categories.service.impl;

import kz.argynsagash.csigrouptest.csigrouptest.features.categories.entities.CategoryEntity;
import kz.argynsagash.csigrouptest.csigrouptest.features.categories.error.CategoryNotFoundFailure;
import kz.argynsagash.csigrouptest.csigrouptest.features.categories.repo.CategoryRepo;
import kz.argynsagash.csigrouptest.csigrouptest.features.categories.service.CategoryService;
import kz.argynsagash.csigrouptest.csigrouptest.features.order.entities.OrderEntity;
import kz.argynsagash.csigrouptest.csigrouptest.features.order.repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;
    private final OrderRepo orderRepo;

    @Override
    public void create(String title) {
        List<OrderEntity> orderEntityList = orderRepo.findAll();
        OrderEntity orderEntity;
        if (orderEntityList.isEmpty()) orderEntity = new OrderEntity();
        else orderEntity = orderEntityList.get(0);
        CategoryEntity category = new CategoryEntity();
        category.setTitle(title);
        orderEntity.getCategoryEntity().add(category);

        categoryRepo.save(category);
        orderRepo.save(orderEntity);
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

    @Override
    public CategoryEntity getById(Long id) {
        return categoryRepo.findById(id).orElseThrow(CategoryNotFoundFailure::new);
    }
}
