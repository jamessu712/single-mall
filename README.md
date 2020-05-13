# single-mall


##### 项目地址
* 配置中心 - https://github.com/jamessu712/micromall-config
* 单体微服务 - https://github.com/jamessu712/single-mall

##### 编译
* mvn clean install -DskipTests
* mvn clean install -PbuildDocker

##### 启动
* docker-compose up
* docker-compose down


##### 环境
* Discovery Server - http://localhost:8761
* Config Server - http://localhost:8888
* biz-service - http://localhost:8081/
* web-service - http://localhost:8082/
* Tracing Server (Zipkin) - http://localhost:9411/zipkin/ (we use [openzipkin](https://github.com/openzipkin/zipkin/tree/master/zipkin-server))
* Admin Server (Spring Boot Admin) - http://localhost:9090
* Grafana Dashboards - http://localhost:3000
* Prometheus - http://localhost:9091