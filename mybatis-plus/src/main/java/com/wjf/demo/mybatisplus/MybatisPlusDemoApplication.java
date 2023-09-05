package com.wjf.demo.mybatisplus;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@EnableKnife4j
@SpringBootApplication(scanBasePackages = {"com.wjf.demo"})
public class MybatisPlusDemoApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(MybatisPlusDemoApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(MybatisPlusDemoApplication.class, args);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();

        String port = environment.getProperty("server.port");
        LOGGER.info("Knife4j接口文档：http://localhost:{}/doc.html", port);
    }
}
