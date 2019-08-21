package com.imooc.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 1、pom文件中对应到spring-cloud-starter-netflix-eureka-client
 * 2、使用@EnableEurekaClient 注解就可以让应用变为Eureka客户端端
 * 3、@SpringBootApplication是启动器
 */
@EnableEurekaClient
@SpringBootApplication
public class EurekaClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class,args);
    }
}
