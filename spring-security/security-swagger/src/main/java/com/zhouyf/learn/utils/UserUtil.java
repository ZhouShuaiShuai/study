package com.zhouyf.learn.utils;

import com.zhouyf.learn.pojo.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.jws.soap.SOAPBinding;

/**
 * @author Zhouyf
 * @Data 2020-08-13  17:11
 */

public class UserUtil {

    public static org.springframework.security.core.userdetails.User getUser(){
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        //details里面可能存放了当前登录用户的详细信息，也可以通过cast后拿到
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) authenticationToken.getDetails();
        return user;
    }

}
