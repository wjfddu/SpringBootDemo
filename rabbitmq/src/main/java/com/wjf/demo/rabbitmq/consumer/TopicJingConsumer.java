package com.wjf.demo.rabbitmq.consumer;

import com.wjf.demo.rabbitmq.config.TopicRabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
@RabbitListener(queues = TopicRabbitConfig.zeroOrMultipleWord)
public class TopicJingConsumer {

    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("TopicJingConsumer收到消息  : " + testMessage.toString());
    }
}