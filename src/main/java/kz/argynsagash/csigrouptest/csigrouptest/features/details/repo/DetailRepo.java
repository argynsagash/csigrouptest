package kz.argynsagash.csigrouptest.csigrouptest.features.details.repo;

import kz.argynsagash.csigrouptest.csigrouptest.features.details.entities.DetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRepo extends JpaRepository<DetailEntity,Long> {
}
