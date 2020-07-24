package com.PiotrKoniorczyk.UltimateSystemRecruitmentTask.controler;

import com.PiotrKoniorczyk.UltimateSystemRecruitmentTask.controler.dto.OrderDto;
import com.PiotrKoniorczyk.UltimateSystemRecruitmentTask.model.Order;
import com.PiotrKoniorczyk.UltimateSystemRecruitmentTask.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/posts")
    public List<OrderDto> getPosts(@RequestParam(required = false) Integer page, Sort.Direction sort){
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return OrderDtoMapper.mapToOrderDtos(orderService.getOrder(pageNumber, sortDirection));
    }

    @GetMapping("/orders/{id}")
    public Order getSingleOrder(@PathVariable long id) {
        return orderService.getSingleOrder(id);
    }

    @PostMapping("/orders")
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @PutMapping("/orders")
    public Order editOrder(@RequestBody Order order) {
        return orderService.editOrder(order);
    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable long id) {
        orderService.deleteOrder(id);
    }
}
