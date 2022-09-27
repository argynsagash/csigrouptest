package kz.argynsagash.csigrouptest.csigrouptest.features.details.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import kz.argynsagash.csigrouptest.csigrouptest.features.details.entities.DetailEntity;
import kz.argynsagash.csigrouptest.csigrouptest.features.details.service.DetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/details")
@Tag(name = "details", description = "The Details API")
public class DetailController {

    private final DetailService detailService;

    @PostMapping("/create/{detailName}/{price}/{categoryId}")
    public String create(@PathVariable String detailName, @PathVariable Double price, @PathVariable Long categoryId) {
        detailService.create(detailName, price, categoryId);
        return "Detail " + detailName + " with " + price + " created";
    }

    @GetMapping
    public List<DetailEntity> getAll() {
        return detailService.getAll();
    }

    @PutMapping("/update")
    public String update(@RequestBody DetailEntity detail) {
        detailService.update(detail.getId(), detail.getTitle(), detail.getPrice());
        return "DONE";
    }

    @DeleteMapping("/delete/{detailId}")
    public void delete(@PathVariable Long detailId) {
        detailService.remove(detailId);
    }

    @GetMapping("/byCategory/{categoryId}")
    public List<DetailEntity> getAllByCategory(@PathVariable Long categoryId){
        return detailService.getDetailsByCategory(categoryId);
    }
}
