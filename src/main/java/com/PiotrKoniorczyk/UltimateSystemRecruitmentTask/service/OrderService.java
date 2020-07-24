package com.PiotrKoniorczyk.UltimateSystemRecruitmentTask.service;

import com.PiotrKoniorczyk.UltimateSystemRecruitmentTask.model.Order;
import com.PiotrKoniorczyk.UltimateSystemRecruitmentTask.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private static final int PAGE_SIZE = 20;
    private final OrderRepository orderRepository;

    public List<Order> getOrder(int page, Sort.Direction sort) {
        return orderRepository.findAllOrders(
                PageRequest.of(page, PAGE_SIZE,
                        Sort.by(sort, "id")
                )
        );
    }

    public Order getSingleOrder(long id) {
        return orderRepository.findById(id)
                .orElseThrow();
    }

    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Transactional
    public Order editOrder(Order order) {
        Order orderEdited = orderRepository.findById(order.getId()).orElseThrow();
        orderEdited.setProductName(order.getProductName());
        orderEdited.setName(order.getName());
        orderEdited.setSurname(order.getSurname());
        return orderEdited;
    }

    public void deleteOrder(long id) {
        orderRepository.deleteById(id);
    }

}
