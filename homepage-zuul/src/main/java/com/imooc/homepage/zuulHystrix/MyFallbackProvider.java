package com.imooc.homepage.zuulHystrix;

import com.alibaba.fastjson.JSON;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * 自定义Zuul回退机制处理器
 * Provides fallback when a failure occurs on a route 英文意思就是说提供一个回退机制当路由后面的服务发生故障时。
 */
public class MyFallbackProvider implements FallbackProvider {
    /**
     * 实现类通过实现getRoute方法，告诉Zuul它是负责哪个route定义的熔断
     * 1、返回值表示需要针对此微服务做回退处理（该名称一定要是注册进入 eureka 微服务中的那个 serviceId 名称）
     *
     * 2、微服务配了路由的话，就用配置的名称
     * return "customers";
     *
     * 3、如果要为所有路由提供默认回退，可以创建FallbackProvider类型的bean并使getRoute方法返回*或null
     * return "*";
     * return "null";
     */
    @Override
    public String getRoute() {
//        return "homepage-eureka-client";
        return "*";

    }

    /**
     * fallbackResponse方法则是告诉 Zuul 断路出现时，它会提供一个什么返回值来处理请求
     */
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            /**
             * 网关向api服务请求是失败了，但是消费者客户端向网关发起的请求是OK的，
             * 不应该把api的404,500等问题抛给客户端
             * 	网关和api服务集群对于客户端来说是黑盒子
             */
            @Override
            public HttpStatus getStatusCode() throws IOException {
                //return status;
//                return HttpStatus.BAD_REQUEST;

                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                //return status.value();

//                return HttpStatus.BAD_REQUEST.value();
                return HttpStatus.OK.value();
            }

            @Override
            public String getStatusText() throws IOException {
                //return status.getReasonPhrase();
                //return HttpStatus.BAD_REQUEST.name();

//                return HttpStatus.BAD_REQUEST.getReasonPhrase();
                return HttpStatus.OK.getReasonPhrase();

            }

            @Override
            public void close() {

            }

            /**
             *
             * @return
             * @throws IOException
             */
            @Override
            public InputStream getBody() throws IOException {
//                JSONObject r = new JSONObject();
//                try {
//                    r.put("state", "9999");
//                    r.put("msg", "系统错误，请求失败");
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
                HashMap map=new HashMap();
                map.put("state", "9999");
                map.put("msg", "系统错误，请求失败");
                System.out.println("1111111111111111111111111111111111111111111");
                return new ByteArrayInputStream(JSON.toJSONString(map).getBytes("UTF-8"));

//                return new ByteArrayInputStream(("fallback:"+MyFallbackProvider.this.getRoute()).getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                //和body中的内容编码一致，否则容易乱码
                headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return headers;
            }
        };
    }
}
