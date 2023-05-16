package com.wjf.demo.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "fanout.C")//监听的队列名称
public class FanoutConsumerC {

    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("FanoutConsumerC收到消息  : " + testMessage.toString());
    }
}