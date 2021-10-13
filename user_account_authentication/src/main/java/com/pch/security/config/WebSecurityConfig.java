package com.pch.security.config;

import com.pch.security.service.SpringDataUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;
import java.util.Arrays;

@Configuration
/** 开启基于方法的安全认证机制，也就是说在web层的controller启用注解机制的安全确认
 * prePostEnabled： 确定 前置注解[@PreAuthorize,@PostAuthorize,..] 是否启用
 * securedEnabled： 确定安全注解 [@Secured] 是否启用
 * jsr250Enabled： 确定 JSR-250注解 [@RolesAllowed..]是否启用
 */
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    /**
     * 记住我后的登录页面
     */
    @Autowired
    private SpringDataUserDetailsService userDetailsService;

    /**
     * 密码加密策略
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    /**
     *  配置安全拦截机制
     */
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable()
                .authorizeRequests()
                //基于url的权限拦截 允许所有请求访问/login
                .antMatchers("/","/login").permitAll()
                .anyRequest()
                .authenticated()
                .and().formLogin()
//                //允许表单登录 登录URL是/login
                .loginPage("/login")
                .loginProcessingUrl("/login")
//                .successHandler(loginSuccessHandler)
                .successForwardUrl("/login-success")
                .failureForwardUrl("/login")
                .and()
                .rememberMe()
                // 设置userDetailsService
                .userDetailsService(userDetailsService)
                // 设置数据访问层
                .tokenRepository(getPersistentTokenRepository())
                // 记住我的时间(秒)
                .tokenValiditySeconds(60 * 60);
                //屏蔽Security 对 CSRF的防范 方法二 在提交的form表单中添加 <input type="hidden" name="${_csrf.parameterName}" value=${_csrf.token}">

//        http//.csrf().disable()//屏蔽Security 对 CSRF的防范 方法二 在提交的form表单中添加 <input type="hidden" name="${_csrf.parameterName}" value=${_csrf.token}">
//                .authorizeRequests()
//                //基于url的权限拦截
//                .antMatchers("/r/r1").hasAnyAuthority("p1")
//                .antMatchers("/login*").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .rememberMe()
//                // 设置userDetailsService
//                .userDetailsService(userDetailsService)
//                // 设置数据访问层
//                .tokenRepository(getPersistentTokenRepository())
//                // 记住我的时间(秒)
//                .tokenValiditySeconds(60 * 60)
//                .and()
//                .formLogin();//退出成功的url
    }

    /**
     * 持久化token
     *
     * Security中，默认是使用PersistentTokenRepository的子类InMemoryTokenRepositoryImpl，将token放在内存中
     * 如果使用JdbcTokenRepositoryImpl，会创建表persistent_logins，将token持久化到数据库
     */
    @Bean
    public PersistentTokenRepository getPersistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepositoryImpl=new JdbcTokenRepositoryImpl();
        jdbcTokenRepositoryImpl.setDataSource(dataSource);
        //启动时创建一张表，这个参数到第二次启动时必须注释掉，因为已经创建了一张表
        // jdbcTokenRepositoryImpl.setCreateTableOnStartup(true);
        return jdbcTokenRepositoryImpl;
    }

    /**
     * 认证管理器 在OAuth2认证服务中要使用 提前放入IOC容器中 授权码模式使用
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //解决静态资源被拦截的问题 完全绕过spring security的所有filter
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
        web.ignoring().antMatchers("/css/**","/images/**","/js/**","/page/**","/vendors/**");
    }
}
