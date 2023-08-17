
# mysql版本 8.0.33

# 一、开发规范

## 应用分层
#### 请求处理层（Web层，也即Controller层）：主要是对访问控制进行转发，各类基本参数校验，或者不复用的业务简单处理等。
#### 业务逻辑层（Service层）：相对具体的业务逻辑服务层。
#### 通用逻辑层（Manager层），它有如下特征： 
#####  1）对第三方平台封装的层，预处理返回结果及转化异常信息，适配上层接口。
#####  2）对 Service 层通用能力的下沉，如缓存方案、中间件通用处理。
#####  3）与 DAO 层交互，对多个 DAO 的组合复用。
#### 数据访问层（DAO层）：与底层 MySQL、Oracle、Hbase、OceanBase等进行数据交互。

## 目录介绍
#### |_annotation：放置项目自定义注解
#### |_aspect：放置切面代码
#### |_config：放置配置类
#### |_constant：放置常量、枚举等定义
#### |__constants：存放常量定义
#### |__enums：存放枚举定义
#### |_controller：放置控制器代码
#### |_filter：放置一些过滤、拦截相关的代码
#### |_mapper：放置数据访问层代码接口
#### |_model：放置数据模型代码
#### |__entity：放置数据库实体对象定义（与数据库表一一对应），仅在DAO层使用，不允许出现在Service层和Controller层
#### |__dto：存放数据传输对象定义（应用内部使用）
#### |__req：存放入参对象定义（前端或服务调用方传过来的参数）
#### |__resp：存放返回对象定义（返回给前端或服务调用方的数据）
#### |_service：放置具体的业务逻辑代码（接口和实现分离），当前包下存放业务逻辑接口定义
#### |__impl：存放业务逻辑具体实现
#### |_util：放置工具类和辅助代码

## 一些注意事项
#### 1、Contorller层参数传递建议不要使用HashMap，建议使用数据模型定义

#### 2、Controller层里可以做参数校验、异常抛出等操作，但建议不要放太多业务逻辑，业务逻辑尽量放到Service层代码中去做

#### 3、Service层做实际业务逻辑，可以按照功能模块做好定义和区分，相互可以调用

#### 4、功能模块Service之间引用时，建议不要渗透到DAO层（或者mapper层），基于Service层进行调用和复用比较合理

#### 5、业务逻辑层Service和数据库DAO层的操作对象不要混用。Controller层的数据对象不要直接渗透到DAO层（或者mapper层）；
#### 同理数据表实体对象Entity也不要直接传到Controller层进行输出或展示。

# 二、踩过的坑
####  1.resources下的目录mybatisplus/mapper一定要检查目录层级，一旦出现目录名为mybatisplus.mapper的失误， 
####  产生报错：Invalid bound statement (not found): com.wjf.demo.mybatisplus.mapper.UserMapper.selectAll