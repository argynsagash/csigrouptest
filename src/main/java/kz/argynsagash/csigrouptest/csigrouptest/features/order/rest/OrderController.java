package kz.argynsagash.csigrouptest.csigrouptest.features.order.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import kz.argynsagash.csigrouptest.csigrouptest.features.order.entities.OrderEntity;
import kz.argynsagash.csigrouptest.csigrouptest.features.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orders")
@Tag(name = "orders", description = "The Orders API")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public List<OrderEntity> getAll() {
        return orderService.getAll();
    }

    @GetMapping("{orderId}")
    public String getById(@PathVariable Long orderId){
        return orderService.getById(orderId).toString();
    }

    @PutMapping("/update/{orderId}/{orderTitle}")
    public void update(@PathVariable Long orderId, @PathVariable String orderTitle) {
        orderService.update(orderId, orderTitle);
    }

    @PostMapping("/create/{title}")
    public void create(@PathVariable String title) {
        orderService.create(title);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        orderService.remove(id);
    }
    @PostMapping("/convert/{id}")
    public void convertToPdf(@PathVariable Long id){
        orderService.convertToPdf(id);
    }
}
