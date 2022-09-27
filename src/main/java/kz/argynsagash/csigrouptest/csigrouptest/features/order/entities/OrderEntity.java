package kz.argynsagash.csigrouptest.csigrouptest.features.order.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kz.argynsagash.csigrouptest.csigrouptest.features.categories.entities.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "orderlst")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Double price = 0.0;
    @JsonIgnore
    @OneToMany
    private List<CategoryEntity> categoryEntity = new ArrayList<>();

    @Override
    public String toString() {
        return "Order: " + title +
                " with total price " + getPrice() +
                " includes \n" + categoryEntity;
    }


    public Double getPrice() {
        for (CategoryEntity category : categoryEntity) {
            price = price + category.getPrice();
        }
        return price;
    }
}
