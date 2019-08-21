package com.imooc.homepage.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
