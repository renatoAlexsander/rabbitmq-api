package com.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {

    @Value("${queue.order.new.name}")
    private String newOrderQueue;

    @Value("${queue.order.delete.name}")
    private String deleteOrderQueue;

    @Bean
    public Queue newOrderQueue() {
        return new Queue(newOrderQueue, true);
    }

    @Bean
    public Queue deleteOrderQueue() {
        return new Queue(deleteOrderQueue, true);
    }

}
