package com.rabbitmq.order.consumer;

import com.rabbitmq.order.dto.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderConsumer {

    @RabbitListener(queues = "${queue.order.new.name}")
    public void receiveNewOrder(@Payload OrderDto order) {
        log.info("Novo pedido recebido " + order);
    }

    @RabbitListener(queues = "${queue.order.delete.name}")
    public void receiveDeleteOrder(@Payload Integer id) {
        log.info("Pedido com id " + id + " foi removido.");
    }
}
