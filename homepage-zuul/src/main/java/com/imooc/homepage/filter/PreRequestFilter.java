package com.imooc.homepage.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * <h1>在过滤器中存储客户端发起的请求时间戳</h1>
 */
@Component
public class PreRequestFilter extends ZuulFilter {
    /**
     * 返回过滤器类型 ；PRE_TYPE:前置过滤器。POST_TYPE：后置过滤器。ROUTE_TYPE:路由过滤器。ERROR_TYPE：错误过滤器
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }
    /**
     * 过滤器执行顺序
     */
    @Override
    public int filterOrder() {
        return 0;
    }
    /**
     * 是否启动此过滤器
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }
    /**
     * 过滤器真正做的事情
     */
    @Override
    public Object run() throws ZuulException {
        System.out.println("222222222222filter-pre");
        //用于在过滤器之间传递消息
        RequestContext ctx=RequestContext.getCurrentContext();
        ctx.set("startTime",System.currentTimeMillis());
        return null;
    }
}
