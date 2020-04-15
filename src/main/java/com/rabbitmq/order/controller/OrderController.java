package com.rabbitmq.order.controller;

import com.rabbitmq.order.dto.OrderDto;
import com.rabbitmq.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public void save(@Valid @RequestBody OrderDto orderDto) {
        orderService.save(orderDto);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id) {
        orderService.delete(id);
    }
}
