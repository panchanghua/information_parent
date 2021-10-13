package com.pch.meeting.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;


@Configuration
public class TokenConfig {

    private final String SigningKey = "pch";

    /**
     * jwt令牌生成方式 给资源配置 ResouceServerConfig 解锁使用
     */
    @Bean
    public TokenStore tokenStore(){
        //jwt令牌存储方案
        return new JwtTokenStore(accessTokenConverter());
    }

    /**
     * 密钥生产方式
     */
    @Bean
    public JwtAccessTokenConverter accessTokenConverter(){
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        //放置对称秘钥 资源服务器使用此秘钥验证
        jwtAccessTokenConverter.setSigningKey(SigningKey);
        return jwtAccessTokenConverter;
    }
}

