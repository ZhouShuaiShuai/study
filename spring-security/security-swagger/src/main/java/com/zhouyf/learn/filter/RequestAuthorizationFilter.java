package com.zhouyf.learn.filter;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;

/**
 * @author Zhouyf
 * @Data 2020-08-13  17:02
 * 用户鉴权
 */

public class RequestAuthorizationFilter extends BasicAuthenticationFilter {

    public RequestAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        System.out.println("URL : "+ request.getRequestURI());
        String path = request.getRequestURI();
        if (path.contains("/user/login")
                || path.contains("/user/register")
                || path.contains("/swagger-ui.html")
                || path.contains("/favicon.ico")
                || path.contains("/webjars/")
                || path.contains("/v2/")
                || path.contains("/swagger-resources")
                || path.equals("/")
        ){
            chain.doFilter(request,response);
        }else {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if(authentication == null) chain.doFilter(request,response);    //未登录
            else {
                //判断是否有访问权限
                if(authentication.getAuthorities().contains(new SimpleGrantedAuthority(path))){
                    chain.doFilter(request,response);
                }else
                    throw new ServletException(MessageFormat.format("path : {0} ; 该用户没有此访问权限",path));
            }
//        Principal principal = (Principal)authentication.getPrincipal();
//        System.out.println("filterName : "+principal.getName());
        }

    }
}
