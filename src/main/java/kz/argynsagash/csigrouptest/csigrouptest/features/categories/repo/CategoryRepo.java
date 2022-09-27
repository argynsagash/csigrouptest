package kz.argynsagash.csigrouptest.csigrouptest.features.categories.repo;

import kz.argynsagash.csigrouptest.csigrouptest.features.categories.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity, Long> {

}
