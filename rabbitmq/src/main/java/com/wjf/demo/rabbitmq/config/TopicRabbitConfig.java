package com.wjf.demo.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author : wjf
 * @CreateTime : 2023/4/4
 * @Description :
 **/
@Configuration
public class TopicRabbitConfig {
    //绑定键
    public final static String man = "topic.man";
    public final static String people = "topic.people";
    public final static String woman = "topic.woman";
    public final static String oneWord = "topic.*";
    public final static String zeroOrMultipleWord = "topic.#";

    @Bean
    public Queue firstQueue() {
        return new Queue(TopicRabbitConfig.man);
    }

    @Bean
    public Queue secondQueue() {
        return new Queue(TopicRabbitConfig.people);
    }

    @Bean
    public Queue thirdQueue() {
        return new Queue(woman);
    }

    @Bean
    public Queue fourthQueue() {
        return new Queue(oneWord);
    }

    @Bean
    public Queue fifthQueue() {
        return new Queue(zeroOrMultipleWord);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }


    //将firstQueue和topicExchange绑定,而且绑定的键值为topic.man
    //这样只要是消息携带的路由键是topic.man,才会分发到该队列
    @Bean
    Binding bindingExchangeMessage() {
        return BindingBuilder.bind(firstQueue()).to(exchange()).with(man);
    }

    //将secondQueue和topicExchange绑定,而且绑定的键值为用上通配路由键规则topic.#
    // 这样只要是消息携带的路由键是以topic.开头,都会分发到该队列
    @Bean
    Binding bindingExchangeMessage2() {
        return BindingBuilder.bind(secondQueue()).to(exchange()).with(people);
    }

    @Bean
    Binding bindingExchangeMessage3() {
        return BindingBuilder.bind(thirdQueue()).to(exchange()).with(woman);
    }

    @Bean
    Binding bindingExchangeMessage4() {
        return BindingBuilder.bind(fourthQueue()).to(exchange()).with(oneWord);
    }

    @Bean
    Binding bindingExchangeMessage5() {
        return BindingBuilder.bind(fifthQueue()).to(exchange()).with(zeroOrMultipleWord);
    }

}