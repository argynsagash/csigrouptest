package kz.argynsagash.csigrouptest.csigrouptest.features.order.service;

import kz.argynsagash.csigrouptest.csigrouptest.features.order.entities.OrderEntity;

import java.util.List;

public interface OrderService {
    void create(String title);
    List<OrderEntity> getAll();
    void update(Long id, String title);
    void remove(Long id);
    OrderEntity getById(Long orderId);
    void convertToPdf(Long orderId);
}
