package com.wjf.demo.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication(scanBasePackages = {"com.wjf.demo.**"})
public class RabbitMQApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(RabbitMQApplication.class, args);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String port = environment.getProperty("server.port");

        System.out.println("Swagger2地址：" + "http://localhost:" + port + "/swagger-ui.html");
    }

}
