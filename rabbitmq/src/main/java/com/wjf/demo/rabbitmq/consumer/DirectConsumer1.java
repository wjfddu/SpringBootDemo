package com.wjf.demo.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "TestDirectQueue")//监听的队列名称 TestDirectQueue
public class DirectConsumer1 {

    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("DirectConsumer1收到消息  : " + testMessage.toString());
    }
}