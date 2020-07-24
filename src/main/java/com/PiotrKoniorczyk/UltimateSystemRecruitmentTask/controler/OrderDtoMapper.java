package com.PiotrKoniorczyk.UltimateSystemRecruitmentTask.controler;


import com.PiotrKoniorczyk.UltimateSystemRecruitmentTask.controler.dto.OrderDto;
import com.PiotrKoniorczyk.UltimateSystemRecruitmentTask.model.Order;

import java.util.List;
import java.util.stream.Collectors;

public class OrderDtoMapper {
    private OrderDtoMapper() {
    }

    public static List<OrderDto> mapToOrderDtos(List<Order> orders) {
        return orders.stream()
                .map(order -> mapToOrderDto(order))
                .collect(Collectors.toList());
    }

    private static OrderDto mapToOrderDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .productName(order.getProductName())
                .name(order.getName())
                .surname(order.getSurname())
                .created(order.getCreated())
                .build();
    }
}

