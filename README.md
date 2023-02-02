# springcloud_learn
学习《深入理解Spring Cloud与微服务构建》,根据书中案例创建的项目

注册发现eureka

负载均衡ribbon

声明式服务调用feign

熔断保护hystrix

服务网关zuul

配置中心SpringCloudConfig

链路追踪zipkin

服务监控SpringBootAdmin

分布式事务seata

  1.springboot,springcloud,springcloudAlibaba,seata的版本要对应，否则会报错，导致项目无法启动，具体版本可以去SpringCloudAlibaba的github查看。
    本demo的版本，springboot:1.5.2.RELEASE,springcloud:Dalston.SR1,spring-cloud-starter-alibaba-seata:1.5.1.RELEASE,seata:0.9.0
    
  2.seata的AT模式需要代理数据源，所以低版本的seata需要手动注入数据源的bean,并且在启动类上要加上@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
    和@Import(SeataDataSourceAutoConfig.class)。
    
  3.spring.cloud.alibaba.seata.tx-service-group: sc_seata_test,这个配置在yml里面要配置。事务组的原理要搞清楚。
