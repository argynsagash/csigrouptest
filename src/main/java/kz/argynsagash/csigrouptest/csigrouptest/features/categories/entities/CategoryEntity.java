package kz.argynsagash.csigrouptest.csigrouptest.features.categories.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kz.argynsagash.csigrouptest.csigrouptest.features.details.entities.DetailEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Double price = 0.0;
    @JsonIgnore
    @OneToMany(mappedBy = "categoryEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetailEntity> detailEntities = new ArrayList<>();

    @Override
    public String toString() {

        return "Detail " + title+
                " total price " + price +
                " includes: \n" + detailEntities;
    }
}
