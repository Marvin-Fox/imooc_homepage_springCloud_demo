package com.imooc.homepage.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * 注解 @CrossOrigin 是解决跨域问题
 * 出于安全原因，浏览器禁止Ajax调用驻留在当前原点之外的资源
 * 跨源资源共享（CORS）是由大多数浏览器实现的W3C规范，允许您灵活地指定什么样的跨域请求被授权
 * Spring Framework 4.2 GA为CORS提供了第一类支持，使您比通常的基于过滤器的解决方案更容易和更强大地配置它。所以springMVC的版本要在4.2或以上版本才支持@CrossOrigin
 */
@CrossOrigin
@RestController
public class ServiceController {

    @Value("${server.port}")
    private String port;

    //    @GetMapping("/hello/{name}")
    @RequestMapping(value = "/hello/{name}",method = RequestMethod.GET)
    public String getHello(@PathVariable("name") String name){
        return "hello "+name+"，被调用的服务提供者(客户端)：homepage-eurekaClient，被调用的服务端口 port："+port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
