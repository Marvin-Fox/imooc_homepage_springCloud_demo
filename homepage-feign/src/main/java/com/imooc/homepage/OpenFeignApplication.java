package com.imooc.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 1、pom文件中对应到spring-cloud-starter-netflix-eureka-client
 * 2、@SpringBootApplication：是启动器
 * 3、@EnableEurekaClient：使用该注解就可以让应用变为Eureka客户端端
 * 4、@EnableFeignClients：开启OpenFeign支持
 * 5、@EnableHystrix：开启 Hystrix 的支持
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.imooc.homepage"})
@EnableHystrix
public class OpenFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignApplication.class,args);
    }
}

