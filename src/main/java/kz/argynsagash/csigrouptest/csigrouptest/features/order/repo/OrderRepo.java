package kz.argynsagash.csigrouptest.csigrouptest.features.order.repo;

import kz.argynsagash.csigrouptest.csigrouptest.features.order.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<OrderEntity, Long> {

}
