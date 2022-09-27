package kz.argynsagash.csigrouptest.csigrouptest.features.details.service;

import kz.argynsagash.csigrouptest.csigrouptest.features.details.entities.DetailEntity;

import java.util.List;

public interface DetailService {
    void create(String title, Double price, Long categoryId);
    List<DetailEntity> getAll();
    void update(Long id, String title, Double price);
    void remove(Long id);

}
