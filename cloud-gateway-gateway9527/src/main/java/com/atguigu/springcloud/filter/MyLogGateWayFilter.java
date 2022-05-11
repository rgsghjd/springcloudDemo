package com.atguigu.springcloud.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;
@Component
public class MyLogGateWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("time:"+new Date()+"\t 执行了自定义的全局过滤器: "+"MyLogGateWayFilter"+"hello");
        String name = exchange.getRequest().getQueryParams().getFirst("uname");
        if(name == null){
            System.out.println("用户名为空....无法登录");
            exchange.getResponse().setStatusCode(HttpStatus.BAD_GATEWAY);
            return exchange.getResponse().setComplete();
        }
        //放行，将请求沿着过滤链条放入下一个过滤器
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
