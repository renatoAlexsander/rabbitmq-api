package com.rabbitmq.order.sender;

import com.rabbitmq.order.dto.OrderDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrderQueueSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${queue.order.new.name}")
    private String newOrderSender;

    @Value("${queue.order.delete.name}")
    private String deleteOrderSender;

    public void sendNewOrder(OrderDto order) {
        rabbitTemplate.convertAndSend(newOrderSender, order);
    }

    public void sendDeleteOrder(Integer id) {
        rabbitTemplate.convertAndSend(deleteOrderSender, id);
    }
}
