
# 一、开发环境
## 1、mysql版本 8.0.33

# 二、开发规范

## I 应用分层
#### 请求处理层（Web层，也即Controller层）：主要是对访问控制进行转发，各类基本参数校验，或者不复用的业务简单处理等。
#### 业务逻辑层（Service层）：相对具体的业务逻辑服务层。
#### 通用逻辑层（Manager层），它有如下特征： 
#####  1.对第三方平台封装的层，预处理返回结果及转化异常信息，适配上层接口。
#####  2.对 Service 层通用能力的下沉，如缓存方案、中间件通用处理。
#####  3.与 DAO 层交互，对多个 DAO 的组合复用。
#### 数据访问层（DAO层）：与底层 MySQL、Oracle、Hbase、OceanBase等进行数据交互。

## II 目录介绍
```
|-annotation：放置项目自定义注解
|-aspect：放置切面代码
|-config：放置配置类
|-constant：放置常量、枚举等定义
|  |-enums：存放枚举定义
|-controller：放置控制器代码
|-filter：放置一些过滤相关的代码
|-interceptor：放置一些拦截相关的代码
|-manager：放置对Service层通用能力下沉的代码
|-mapper：放置mybatis-plus数据访问层代码接口
|-model：放置数据模型代码
|  |-dto：存放接口入参对象定义（前端或服务调用方传过来的参数）
|  |-entity：放置数据库实体对象定义（与数据库表一一对应），仅在DAO层使用，不允许出现在Controller层
|  |-vo：存放接口出参对象定义（返回给前端或服务调用方的数据）
|-service：放置具体的业务逻辑代码（接口和实现分离），当前包下存放业务逻辑接口定义
|  |-impl：存放业务逻辑具体实现
|-util：放置工具类和辅助代码
```

## III 强制要求
#### 1.枚举类名带上 Enum 后缀，常量类名带上 Consts 后缀


## IV 阿里Java开发手册（黄山版）部分规范解释
#### 四.8 【强制】任何货币金额，均以最小货币单位且为整型类型进行存储。
####    比如说人民币的最小单位是分，那假设一个商品的价格是1元钱，那就存到数据库的 price 字段，字段类型是 int 或者 bigint，值为 100，单位是分，也就是100分。
  

## V 分层的一些建议
#### 1.Contorller层参数传递建议不要使用HashMap，建议使用数据模型定义

#### 2.Controller层里可以做参数校验、异常抛出等操作，但建议不要放太多业务逻辑，业务逻辑尽量放到Service层代码中去做

#### 3.Service层做实际业务逻辑，可以按照功能模块做好定义和区分，相互可以调用

#### 4.功能模块Service之间引用时，建议不要渗透到DAO层（或者mapper层），基于Service层进行调用和复用比较合理

#### 5.业务逻辑层Service和数据库DAO层的操作对象不要混用。Controller层的数据对象不要直接渗透到DAO层（或者mapper层）；同理数据表实体对象Entity也不要直接传到Controller层进行输出或展示。

## VI 开发时的一些建议
#### 1.通过序列化实现深拷贝:通过clone方法实现深拷贝是比较麻烦的一件事情，这里推荐大家可以通过序列化、反序列化的方式实现深拷贝。我们可以直接使用commons-lang3包的序列化、反序列工具类。

#### 2.浮点数的精度和等值比较需要格外留意

## VII git代码提交规范
```
一、提交格式
type（scope）: message
二、参数介绍：
1、type：指的代码的提交类型，不同的提交类型表示对应不同的代码改动，比如：
    feat：新增功能
    fix：bug修复
    docs：文档更新
    style：代码格式改变，不影响程序逻辑的代码修改(修改空白字符，格式缩进，补全缺失的分号等，没有改变代码逻辑)
    refactor：重构代码(既没有新增功能，也没有修复bug)
    perf：性能,体验优化
    test：新增测试用例或是更新现有测试
    build：主要目的是修改项目构建系统(例如 glup，webpack，rollup 的配置等)的提交
    ci：主要目的是修改项目继续集成流程(例如 Travis，Jenkins，GitLab CI，Circle等)的提交
    chore：不属于以上类型的其他类，比如构建流程, 依赖管理或辅助工具的变动
    revert：回滚某个更早之前的提交（如果提交恢复了以前的提交，它应该以revert: 开始，如revert:This reverts commit <hash>.）
2、scope：用于说明commit影响的范围，比如：权限模块、还是首页
3、message： 对提交的代码做一个简短的说明，不能过长。
三、示例
fix（系统菜单图标）:添加缺少的图标
```

# 三、踩过的坑
####  1.Springfox使用的路径匹配是基于AntPathMatcher的，而Spring Boot 2.6.X默认使用的是PathPatternMatcher，所以需要配置此参数 spring.mvc.pathmatch.matching-strategy: ant_path_matcher，否则启动报错
