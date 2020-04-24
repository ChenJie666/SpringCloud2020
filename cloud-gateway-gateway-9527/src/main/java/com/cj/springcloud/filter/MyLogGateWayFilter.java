package com.cj.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter,Ordered {


    //TODO 过滤请求
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("*********come in MyLogGateWayFilter:"+new Date());
        //TODO 获取请求参数并获取uname参数的值
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if (uname == null) {
            log.info("*******用户名为null，非法用户");
            //TODO 设置响应码为406
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            //TODO 返回拒绝的响应
            return exchange.getResponse().setComplete();
        }
        //TODO 进入下一个过滤器
        return chain.filter(exchange);
    }

    //TODO 加载过滤器的顺序，越小优先级越高
    @Override
    public int getOrder() {
        return 0;
    }
}
