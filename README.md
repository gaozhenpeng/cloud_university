# 项目介绍
  本项目是基于Springboot 和 SpringCloud为基础的微服务架构实践项目。
  同时也可以作为基础框架作为新项目的微服务基础架构。本项目的业务场景是已
  网上课堂为样例制作的一个demo版本。
# 如何开始
## 源代码运行
* 下载代码 ``git clone ``
* 进入代码根目录执行 ``mvn clean package -Dskiptests`` 编译打包代码
* 进入server/discovery/target 目录执行 ``java -jar discovery-0.1-SNAPSHOT.jar`` 启动eureka服务
* 进入server/hystrix/target 目录执行 ``java -jar hystrix-0.1-SNAPSHOT.jar`` 启动hystrix 服务
* 进入server/zipkin/target 目录执行 ``java -jar zipkin-0.1-SNAPSHOT.jar`` zipkin 服务
* 进入server/monitor/target 目录执行 ``java -jar monitor-0.1-SNAPSHOT.jar`` springbootadmin 服务
* 进入server/gateway/target 目录执行 ``java -jar gateway-0.1-SNAPSHOT.jar`` API网关 服务
* 进入server/config/target 目录执行 ``java -jar config-0.1-SNAPSHOT.jar`` 统一配置 服务
启动业务代码
* 进入user-service/target 目录执行 ``java -jar user-0.1-SNAPSHOT.jar`` 启动用户微服务
## 容器运行方式
* 当前docker镜像未托管，待上传后补充。
* 当前项目已编写了docker file ，可以通过docker自行构建镜像部署
* docker-compose 进行docker编排方式 ，docker-compose 使用可自行查询，docker-compose.yml在项目根目录下
* kubernates 进行docker编排方式，当前处于试验阶段待进一步补充
# 效果展示与说明
## 微服务监控与管理
![](https://github.com/VerRan/photo/blob/master/%E5%BE%AE%E6%9C%8D%E5%8A%A1%E7%9B%91%E6%8E%A7-springbootadmin.png)
## 微服务调用链监控
![](https://github.com/VerRan/photo/blob/master/%E5%BE%AE%E6%9C%8D%E5%8A%A1-%E8%B0%83%E7%94%A8%E9%93%BE%E7%9B%91%E6%8E%A7.png)
## 微服务熔断与处理
![](https://github.com/VerRan/photo/blob/master/%E6%9C%8D%E5%8A%A1%E7%86%94%E6%96%AD%E7%9B%91%E6%8E%A7%E4%B8%8E%E5%A4%84%E7%90%86.png)

# 架构说明
## 技术架构图
![](https://github.com/VerRan/photo/blob/master/%E7%B3%BB%E7%BB%9F%E6%8A%80%E6%9C%AF%E6%9E%B6%E6%9E%84%E5%9B%BE.png)
## 系统模块说明
![总体目录](https://github.com/VerRan/photo/blob/master/%E6%A8%A1%E5%9D%97%E8%AF%B4%E6%98%8E.png)
![微服务目录](https://github.com/VerRan/photo/blob/master/%E6%A8%A1%E5%9D%97%E8%AF%B4%E6%98%8E2.png)
