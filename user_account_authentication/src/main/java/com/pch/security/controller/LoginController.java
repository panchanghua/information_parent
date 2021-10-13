package com.pch.security.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.pch.security.mapper.UserMapper;
import feign.HeaderMap;
import jdk.nashorn.internal.runtime.JSONListAdapter;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@CrossOrigin("*")
public class LoginController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/login-success")
    public String loginSuccess(HttpServletRequest request, HttpServletResponse response){
        // 安全上下文中 取出用户的身份信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //判断用户是否有oauth token
        if (!(authentication instanceof UsernamePasswordAuthenticationToken)) {
            //UsernamePasswordAuthenticationToken
            return authentication.toString();
        }
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) authentication;
        Map<String, Object> jsonToken = new HashMap<>();
        if (authenticationToken != null) {
            // 获取用户身份
            String name = authenticationToken.getName();
            System.out.println(name);
            Object principal = authenticationToken.getPrincipal();
            System.out.println(principal);
            Object credentials = authenticationToken.getCredentials();
            System.out.println(credentials);
            Object details = authenticationToken.getDetails();
            System.out.println(details);
            // 取得用户权限
            List<String> authorities = new ArrayList<>();
            authenticationToken.getAuthorities().stream().forEach(s -> authorities.add(((GrantedAuthority) s).getAuthority()));
            System.out.println(authorities);
            jsonToken.put("name", name);
            jsonToken.put("principal", principal);
            jsonToken.put("authorities", authorities);
            System.out.println(jsonToken);
            return jsonToken.toString();
        }

        // 将信息编码后放入request的header中并转发给微服务
        return "登录成功";
    }

    @GetMapping(value = "/r/r1")
    //@PreAuthorize在方法调用前拦截
    //@PostAuthorize在方法调用后进行拦截
    @PreAuthorize("hasAuthority('p1')") //拥有p1权限可以访问该资源
    public String r1(HttpSession session){
        return "访问资源1";
    }

    @GetMapping(value = "/r/r2")
    @PreAuthorize("hasAnyAuthority('p1','p2')") //拥有p1 p2权限可以访问该资源
    public String r2(HttpSession session){
        return "访问资源2";
    }

    @GetMapping(value = "/r/r3")
    @PostAuthorize("isAnonymous()") //可以匿名访问
    public String r3(HttpSession session){
        return "访问资源3";
    }

    private String getUsername(){
        String username = null;
        //当前通过认证的用户身份信息
        Authentication authenticaton = SecurityContextHolder.getContext().getAuthentication();
        //用户身份
        Object principal = authenticaton.getPrincipal();
        System.out.println(authenticaton);
        System.out.println(principal);
        if (principal == null){
            username = "游客";
        }
        if (principal instanceof UserDetails){
            UserDetails userDetails = (UserDetails) principal;
            username = userDetails.getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }
}
