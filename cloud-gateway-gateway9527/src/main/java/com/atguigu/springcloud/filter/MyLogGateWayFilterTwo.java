package com.atguigu.springcloud.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * 定义的第二个过滤器,请求会通过所有的过滤链，按优先级通过，数字越小越先通过,可以进行请求的鉴权，日志记录,修改请求或者响应等
 */
@Component
public class MyLogGateWayFilterTwo implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("time:"+new Date()+"\t 执行了自定义的日志过滤器: "+"MyLogGateWayFilter"+"hello");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 21;
    }
}
