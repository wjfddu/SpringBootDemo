package com.wjf.demo.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
@RabbitListener(queues = "topic*")
public class TopicXingConsumer {

    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("TopicXingConsumer收到消息  : " + testMessage.toString());
    }
}