# SpringBootDemo

一、模块说明
    common           公共包
    java8base        java基础练习
    web              普通web模块，最原始的web工程
    rabbitmq         rabbitmq整合与使用

二、踩过的坑
1.springboot 2.7.11跟swagger 2.9.2不匹配，需要降低Spring Boot 版本到2.6.x以下版本，或者升级swagger到3.x
2.web模块使用common模块的swagger，需要将包扫描路径往上提一层（配置包扫描路径为"com.wjf.demo"），不然swagger无法生效
