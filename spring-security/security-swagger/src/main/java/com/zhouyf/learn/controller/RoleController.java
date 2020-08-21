package com.zhouyf.learn.controller;

import com.zhouyf.learn.pojo.Role;
import com.zhouyf.learn.result.Result;
import com.zhouyf.learn.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zhouyf
 * @Data 2020-08-19  9:22
 */
@RestController
@RequestMapping(value = "role")
@Api(tags = {"角色相关接口"})
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "添加角色", notes = "使用管理员用户才能添加")
    @GetMapping("addRole")
    public Result addRole(Role role,String resourceIds){
        if(null!=role && !StringUtils.isEmpty(resourceIds)){
            return roleService.addRole(role,resourceIds.split(","));
        }
        else return new Result("传入数据为空",null);
    }

    @ApiOperation(value = "删除角色", notes = "使用管理员用户才能添加")
    @GetMapping("delRole")
    public Result delRole(String roleId){
        if(StringUtils.isEmpty(roleId))
            return new Result("传入数据为空",null);
        else
            return roleService.delUser(roleId);
    }

    @ApiOperation(value = "修改角色", notes = "使用管理员用户才能添加")
    @GetMapping("updateRole")
    public Result updateRole(Role role,String resourceIds){
        if(null!=role && !StringUtils.isEmpty(resourceIds)){
            return roleService.updateRole(role,resourceIds.split(","));
        }
        else return new Result("传入数据为空",null);
    }

    @ApiOperation(value = "查询角色列表", notes = "使用管理员用户才能添加")
    @GetMapping("findRole")
    public Result findRole(String roleName,Boolean isUse){
        return roleService.findRole(roleName,isUse);
    }

}
