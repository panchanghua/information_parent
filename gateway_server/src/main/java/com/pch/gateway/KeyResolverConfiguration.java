package com.pch.gateway;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

//漏桶算法限流
@Configuration
public class KeyResolverConfiguration {
    /**
     * 编写基于请求路径的限流规则
     * 一个容器中只能有一个KeyResolver
     */
    //@Bean
    public KeyResolver pathKeyResolver(){
        //自定义的KeyResolver
        return new KeyResolver() {
            /**
             * ServerWebExchange
             *      上下文参数
             */
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                return Mono.just( exchange.getRequest().getPath().toString() );
            }
        };
    }
    /**
     * 编写基于请求参数的限流规则
     */
    @Bean
    public KeyResolver userKeyResolver(){
        return exchange -> Mono.just(
                exchange.getRequest().getQueryParams().getFirst("userId")
        );
    }
    /**
     * 编写基于ip的限流规则
     */
    //@Bean
    public KeyResolver ipKeyResolver(){
        return exchange -> Mono.just(
                exchange.getRequest().getHeaders().getFirst("X-Forwarded-For")
        );
    }
}
