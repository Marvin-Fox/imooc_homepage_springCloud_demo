package com.imooc.homepage.controllerHystrix;

import com.imooc.homepage.controllerFeign.IServiceFeign;
import org.springframework.stereotype.Component;

@Component
public class ServiceHystrix implements IServiceFeign {
    @Override
    public String getHello(String name) {
        return "sorry! 网络异常，服务暂时无法访问。 请求的name为:"+name;
    }
}
