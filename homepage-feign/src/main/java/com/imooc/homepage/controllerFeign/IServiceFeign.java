package com.imooc.homepage.controllerFeign;


import com.imooc.homepage.controllerHystrix.ServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @FeignClient(name = "")指定这是feign客户端; name属性指明要调用的服务名
 * 注意：这里一定要加 @Component 注解，因为 @FeignClient 并没有将类托管给spring的功能
 * 如果不加 @Component 在使用 @Autowired 注入的时候会出现问题，找不到Bean对象
 */
@FeignClient(name = "homepage-eureka-client",fallback = ServiceHystrix.class)
@Component
public interface IServiceFeign {

    // 指定要调用的服务，要和调用的服务调用方式保持一致
//    @GetMapping("/hello/{name}")
    @RequestMapping(value = "/hello/{name}",method = RequestMethod.GET)
    public String getHello(@PathVariable("name") String name);
}
