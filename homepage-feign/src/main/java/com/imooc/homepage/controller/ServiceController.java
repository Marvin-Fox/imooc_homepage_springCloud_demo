package com.imooc.homepage.controller;

import com.imooc.homepage.controllerFeign.IServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
public class ServiceController {
    /**
     * 1、注入IServiceFeign（feign的客户端，来调用服务）
     * 注意：这里我使用 @Autowired 时编译器会报红 Could not autowire. No beans of 'IServiceFeign' type found
     * 原因是如果没有在 IServiceFeign 上声明 @Component 就不会将它托管给spring容器
     */
    @Autowired
//    @Resource
    private IServiceFeign iServiceFeign;

//    @GetMapping("/consumer/{name}")
    @RequestMapping(value = "/consumer/{name}",method = RequestMethod.GET)
    public String consumer(@PathVariable("name") String name) {
        // 调用具体的服务
        return iServiceFeign.getHello(name);
    }
    public void setiServiceFeign(IServiceFeign iServiceFeign) {
        this.iServiceFeign = iServiceFeign;
    }
}
