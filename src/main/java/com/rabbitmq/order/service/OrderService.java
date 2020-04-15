package com.rabbitmq.order.service;

import com.rabbitmq.order.dto.OrderDto;
import com.rabbitmq.order.sender.OrderQueueSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderQueueSender orderQueueSender;

    public void save(OrderDto orderDto) {
        orderQueueSender.sendNewOrder(orderDto);
    }

    public void delete(Integer id) {
        orderQueueSender.sendDeleteOrder(id);
    }
}
