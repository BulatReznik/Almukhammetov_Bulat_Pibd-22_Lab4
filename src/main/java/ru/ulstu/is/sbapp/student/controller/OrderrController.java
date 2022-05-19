package ru.ulstu.is.sbapp.student.controller;

import org.springframework.web.bind.annotation.*;
import ru.ulstu.is.sbapp.student.controller.dto.OrderrDto;
import ru.ulstu.is.sbapp.student.service.OrderrService;

import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/orderr")
public class OrderrController {

    private final OrderrService orderrService;

    public OrderrController(OrderrService orderrService) {
        this.orderrService = orderrService;
    }

    @GetMapping("/{id}")
    public OrderrDto getOrderr(@PathVariable Long id) {
        return new OrderrDto(orderrService.findOrderr(id));
    }

    @GetMapping("/")
    public List<OrderrDto> getOrderrs() {
        return orderrService.findAllOrderrs().stream()
                .map(OrderrDto::new)
                .toList();
    }

    @PostMapping("/")
    public OrderrDto createOrderr(@RequestBody @Valid OrderrDto orderrDto) {
        return orderrService.addOrderr(orderrDto);
    }

    @PutMapping("/{id}")
    public OrderrDto updateOrderr(@RequestBody @Valid OrderrDto orderrDto) {
        return orderrService.updateOrderr(orderrDto);
    }

    @DeleteMapping("/{id}")
    public OrderrDto deleteOrderr(@PathVariable Long id) {
        return new OrderrDto(orderrService.deleteOrderr(id));
    }


}