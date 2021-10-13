package com.pch.meeting.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;


@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    public static final String RESOURCE_ID = "meeting";

    @Autowired
    TokenStore tokenStore;


    /**
     * 指定当前资源的id和存储方案
     * @param resources
     * @throws Exception
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources
                //资源id
                .resourceId(RESOURCE_ID)
                //验证令牌的服务  使用jwt令牌后不需要 改成tokenStore
//                .tokenServices(tokenServices())
                .tokenStore(tokenStore)
                .stateless(true);
    }

    /**
     * 指定不同请求所需要的权限
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //判断是否scope是否为ROLE_ADMIN
                .antMatchers("/**").permitAll()//.access("#oauth2.hasScope('ROLE_ADMIN')")
//                //指定不同请求方式访问资源所需要的权限 一般查询是read 其余是write
//                .antMatchers(HttpMethod.GET,"/**").access("#oauth2.hasScope('read')")
//                .antMatchers(HttpMethod.POST,"/**").access("#oauth2.hasScope('write')")
//                .antMatchers(HttpMethod.PATCH,"/**").access("#oauth2.hasScope('write')")
//                .antMatchers(HttpMethod.PUT,"/**").access("#oauth2.hasScope('write')")
//                .antMatchers(HttpMethod.DELETE,"/**").access("#oauth2.hasScope('write')")
//                .and()
//                .headers().addHeaderWriter((request, response) -> {
//            // 允许跨域
//            response.addHeader("Access-Control-Allow-Origin","*");
//            if (request.getMethod().equals("OPTIONS")){
//                // 如果是跨域请求的预检请求 则原封不动的向下传达请求头信息
//                response.setHeader("Access-Control-Allow-Methods", request.getHeader("Access-Control-Allow-Methods"));
//                response.setHeader("Access-Control-Allow-Headers", response.getHeader("Access-Control-Allow-Headers"));
//            }
//        })
                .and()
                //禁用csrf防护
                .csrf().disable();
                //禁用session 使用jwt令牌就不需要session
                //.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }


    /**
     * 验证令牌  从认证服务中验证令牌的正确性
     * 如果使用令牌就不用从认证服务验证令牌
     */
//    @Bean
//    public ResourceServerTokenServices tokenServices(){
//        RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
//        remoteTokenServices.setCheckTokenEndpointUrl("http://localhost:8080/uaa/auth/check_token");
//        remoteTokenServices.setClientId("c1");
//        remoteTokenServices.setClientSecret("secret");
//        return remoteTokenServices;
//    }



}

