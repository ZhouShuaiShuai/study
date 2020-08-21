package com.zhouyf.learn.controller;

import com.zhouyf.learn.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.security.Principal;

/**
 * @author Zhouyf
 * @Data 2020-08-14  10:51
 */
@RestController
@Api(tags = {"测试权限相关接口"})
public class TestController {

    @GetMapping("/test1")
    @ApiOperation(value = "测试")
    public Result test1(Principal principal){
        System.out.println("controllerName : " + principal.getName());
        return new Result("/test1");
    }

    @GetMapping("/test2")
    @ApiOperation(value = "测试")
    public Result test2(Principal principal){
        System.out.println("controllerName : " + principal.getName());
        return new Result("/test2");
    }

    @GetMapping("/test3")
    @ApiOperation(value = "测试")
    public Result test3(Principal principal){
        System.out.println("controllerName : " + principal.getName());
        return new Result("/test1");
    }

    @GetMapping("/admin")
    @ApiOperation(value = "测试")
    public Result admin(Principal principal){
        System.out.println("controllerName : " + principal.getName());
        return new Result("/admin");
    }

    @GetMapping("/user")
    @ApiOperation(value = "测试")
    public Result user(Principal principal){
        System.out.println("controllerName : " + principal.getName());
        return new Result("/user");
    }


    @GetMapping("/logout1")
    public Result logout1(){
        return new Result("用户登陆过期");
    }

}
