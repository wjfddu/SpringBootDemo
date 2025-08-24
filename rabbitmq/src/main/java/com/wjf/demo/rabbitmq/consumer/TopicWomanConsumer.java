package com.wjf.demo.rabbitmq.consumer;

import com.wjf.demo.rabbitmq.config.TopicRabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
@RabbitListener(queues = TopicRabbitConfig.woman)
public class TopicWomanConsumer {

    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("TopicWomanConsumer收到消息  : " + testMessage.toString());
    }
}