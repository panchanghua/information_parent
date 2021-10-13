package com.pch.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

//令牌管理 令牌的配置
@Configuration
public class TokenConfig {
    //令牌存储策略
//    @Bean
//    public TokenStore tokenStore(){
//        //内存方式生成普通令牌
//        return new InMemoryTokenStore();
//    }
    /**
     *     内存方式生成令牌会把所有用户信息放在内存 然后生成一个token给客户端 客户端访问资源时带上token 资源服务器得到token到令牌存储端获取令牌对应的用户的权限
     *     请求资源过多的话 会经常访问这个服务器 内存占用多 资源消耗大
     *     jwt令牌将用户信息放入令牌中发给客户端 其中有三部分 最后一部分采用前两部分相加在和SigningKey加密
     */
    private String SigningKey = "pch";
    //jwt令牌生成方式
    @Bean
    public TokenStore tokenStore(){
        //jwt令牌存储方案
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter(){
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        //放置对称秘钥 资源服务器使用此秘钥验证
        jwtAccessTokenConverter.setSigningKey(SigningKey);
        return jwtAccessTokenConverter;
    }
}
