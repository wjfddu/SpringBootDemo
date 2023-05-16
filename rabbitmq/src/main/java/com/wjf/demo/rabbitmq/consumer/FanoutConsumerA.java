package com.wjf.demo.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "fanout.A")//监听的队列名称
public class FanoutConsumerA {

    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("FanoutConsumerA收到消息  : " + testMessage.toString());
    }
}