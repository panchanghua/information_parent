package com.pch.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.pch.gateway.common.EncryptUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR;

@Component
/**
 * 实现一个全局过滤器
 *      实现GlobalFilter，Ordered接口
 */
public class LoginFilter implements GlobalFilter,Ordered {
    private static final String ALL = "*";
    private static final String MAX_AGE = "18000L";
    /**
     * 执行过滤器中的业务逻辑
     *      对请求参数中的access-token进行判断
     *      如果存在就表示认证成功
     *      如果不存在就代表认证失败
     *  ServerWebExchange 相当于请求和响应的上下文 zuul中的RequestContext
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        // 获取request上下文 用来将信息放入request的header中
//        ServerHttpRequest request = exchange.getRequest();
//        // 安全上下文中 取出用户的身份信息
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        //判断用户是否有oauth token
//        if (!(authentication instanceof OAuth2Authentication)) {
//            //UsernamePasswordAuthenticationToken
//            return chain.filter(exchange);
//        }
//        OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) authentication;
//        // 获得用户身份信息
//        Authentication userAuthentication = oAuth2Authentication.getUserAuthentication();
//        // 将其他信息也放入map中
//        OAuth2Request oAuth2Request = oAuth2Authentication.getOAuth2Request();
//        Map<String, String> requestParametes = oAuth2Request.getRequestParameters();
//        Map<String, Object> jsonToken = new HashMap<>(requestParametes);
//        if (userAuthentication != null) {
//            // 获取用户身份
//            String principal = userAuthentication.getName();
//            // 取得用户权限
//            List<String> authorities = new ArrayList<>();
//            userAuthentication.getAuthorities().stream().forEach(s -> authorities.add(((GrantedAuthority) s).getAuthority()));
//            jsonToken.put("principal", principal);
//            jsonToken.put("authorities", authorities);
//        }
//
//        request.getHeaders().add("json-token", EncryptUtil.encrypt(JSON.toJSONString(jsonToken)));
        // 将信息编码后放入request的header中并转发给微服务
//        ServerHttpResponse response = exchange.getResponse();
//        HttpHeaders headers = response.getHeaders();
//        headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, ALL);
//        headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "POST, GET, PUT, OPTIONS, DELETE, PATCH");
//        headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
//        headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, ALL);
//        headers.add(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, ALL);
//        headers.add(HttpHeaders.ACCESS_CONTROL_MAX_AGE, MAX_AGE);
        return chain.filter(exchange);
//
//
//        System.out.println("执行过滤器");
//        //1.获取请求参数access-token
//        String token = exchange.getRequest().getQueryParams().getFirst("access-token");
//        //2.判断是否存在
//        if (token == null){
//            ServerHttpRequest request = exchange.getRequest();
//            ServerHttpResponse response = exchange.getResponse();
//            HttpHeaders headers = response.getHeaders();
//            headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
//            headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "POST, GET, PUT, OPTIONS, DELETE, PATCH");
//            headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
//            headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "*");
//            headers.add(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, ALL);
//            headers.add(HttpHeaders.ACCESS_CONTROL_MAX_AGE, MAX_AGE);
//            try {
//                exchange.getAttributes().put(GATEWAY_REQUEST_URL_ATTR, new URI("http://localhost:8081/"));
//            } catch (URISyntaxException e) {
//                e.printStackTrace();
//            }
//            return chain.filter(exchange);
////            //3.如果不存在认证失败
////            System.out.println("没有登录");
////            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
////            //请求结束
////            return exchange.getResponse().setComplete();
//        }
//        //4.如果存在 继续执行
//        return chain.filter(exchange);
    }

    /**
     * 指定过滤器的执行顺序 数字越小 优先级越高
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
