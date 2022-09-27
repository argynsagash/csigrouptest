package kz.argynsagash.csigrouptest.csigrouptest.features.details.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kz.argynsagash.csigrouptest.csigrouptest.features.categories.entities.CategoryEntity;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "detail")
public class DetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    Double price;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private CategoryEntity categoryEntity;
}
