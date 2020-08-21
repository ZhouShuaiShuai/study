package com.zhouyf.learn.controller;

import com.zhouyf.learn.pojo.User;
import com.zhouyf.learn.result.Result;
import com.zhouyf.learn.service.UserService;
import com.zhouyf.learn.utils.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author Zhouyf
 * @Data 2020-08-13  10:31
 */
@RestController
@RequestMapping(value = "user")
//@RequestMapping(value = "user",produces = "application/json;charset=utf-8")
@Api(tags = {"用户相关接口"})
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "添加用户", notes = "使用管理员用户才能添加")
    @GetMapping("addUser")
    public Result addUser(User user, String roleIds){
        if(user!=null&& roleIds!=null && roleIds.split(",").length>0)
            return userService.addUser(user,roleIds.split(","));
        else
            return new Result("传入数据为空",null);
    }

    @ApiOperation(value = "删除用户",notes = "使用管理员用户才能添加")
    @GetMapping("delUser")
    public Result delUser(String userId){
        if(StringUtils.isEmpty(userId))
            return new Result("传入数据为空",null);
        else
            return userService.delUser(userId);
    }

    @ApiOperation(value = "修改用户权限",notes = "使用管理员用户才能添加")
    @GetMapping("updateUser")
    public Result updateUser(String userId,String roleIds){
        if(!StringUtils.isEmpty(userId)&& roleIds!=null && roleIds.split(",").length>0)
            return userService.updateUser(userId,roleIds.split(","));
        else
            return new Result("传入数据为空",null);
    }

    @ApiOperation(value = "用户查询",notes = "使用管理员用户才能添加")
    @GetMapping("findUser")
    public Result findUser(String name,Boolean isUse,String roleIds){
        return userService.findUser(name,isUse,roleIds);
    }

}
