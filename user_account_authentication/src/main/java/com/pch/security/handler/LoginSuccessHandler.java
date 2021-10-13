package com.pch.security.handler;
import com.pch.security.constant.ResultCode;
import com.pch.security.domain.User;
import com.pch.security.pojo.AuthUserDetails;
import com.pch.security.pojo.AuthUserPoJo;
import com.pch.security.utils.ResUtil;
import com.pch.security.utils.ResponseUtil;
import com.pch.security.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * @ClassName LoginSuccessHandlerFilter
 * @Description 登陆认证成功处理过滤器
 * @Author liuheming
 * @Date 2019/5/6 16:27
 * @Version 1.0
 **/
//@Component
//public class LoginSuccessHandler implements AuthenticationSuccessHandler {
//    @Autowired
//    private TokenUtil tokenUtil;
//
//    /**
//     * @Author liuheming
//     * @Description 用户认证成功后 生成token并返回
//     * @Date 8:50 2019/5/7
//     * @Param [request, response, authentication]
//     * @return void
//     **/
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//
//        //从内存中获取当前认证用户信息
//        UserDetails authUserDetails = (UserDetails)authentication.getPrincipal();
//        AuthUserPoJo userPoJo = new AuthUserPoJo(null,authUserDetails.getUsername(),authUserDetails.getPassword(),null,null,null);
////        //创建token
//        String accessToken = tokenUtil.createAccessJwtToken(authUserDetails);
//        String refreshToken = tokenUtil.createRefreshToken(authUserDetails);
//
//        HashMap<String,String> map=new HashMap<>();
//        map.put("accessToken",accessToken);
//        map.put("refreshToken",refreshToken);
//        ResponseUtil.out(response, ResUtil.getJsonStr(ResultCode.OK,"登录成功",map));
//    }
//
//}