
# SpringBootDemo

## jdk版本 1.8.0_371  
## maven版本：apache-maven-3.6.3  
## settings.xml配置
    <mirrors>  
      <mirror>  
        <id>nexus-aliyun</id>  
        <mirrorOf>central</mirrorOf>  
        <name>Nexus aliyun</name>  
        <url>http://maven.aliyun.com/nexus/content/groups/public</url>  
      </mirror>  
    </mirrors>

## 一、模块说明

    java8base        java基础练习

    common           公共包

    common-web       web模块基础依赖

    web              普通web模块

    rabbitmq         rabbitmq整合与使用

    mybatis          整合mybatis

    mybatis-plus     整合mybatis-plus

## 二、踩过的坑

## 三、知识点笔记
    1.springmvc接口响应实现流程
    WebMvcAutoConfiguration -> @Bean RequestMappingHandlerAdapter 
        WebMvcConfigurationSupport.requestMappingHandlerAdapter() -> adapter.setMessageConverters(getMessageConverters()); // HttpMessageConverter消息转换器
        RequestMappingHandlerAdapter.afterPropertiesSet() -> getDefaultReturnValueHandlers() -> new RequestResponseBodyMethodProcessor() -- 处理@ResponseBody修饰的Controller或Controller里的方法
        RequestResponseBodyMethodProcessor.handleReturnValue -> writeWithMessageConverters -- 转换消息
