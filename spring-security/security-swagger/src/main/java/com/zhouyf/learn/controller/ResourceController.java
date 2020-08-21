package com.zhouyf.learn.controller;

import com.zhouyf.learn.pojo.Resource;
import com.zhouyf.learn.result.Result;
import com.zhouyf.learn.service.ResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author Zhouyf
 * @Data 2020-08-19  9:36
 */
@RestController
@RequestMapping(value = "resource")
@Api(tags = {"资源相关接口"})
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @ApiOperation(value = "添加资源", notes = "使用管理员用户才能添加")
    @GetMapping("addResource")
    public Result addResource(Resource resource){
        if(resource!=null){
            return resourceService.addResource(resource);
        }
        return new Result("ERROR! 资源为空",null);
    }

    @ApiOperation(value = "删除资源", notes = "使用管理员用户才能添加")
    @GetMapping("delResource")
    public Result delResource(String resourceIds){
        if(resourceIds.split(",").length > 0){
            return resourceService.delResource(resourceIds.split(","));
        }
        return new Result("ERROR! ID为空",null);
    }

    @ApiOperation(value = "修改资源", notes = "使用管理员用户才能添加")
    @GetMapping("updateResource")
    public Result updateResource(Integer resourceId , Resource resource){
        if(resourceId!=null && resource!=null){
            return resourceService.updateResource(resourceId,resource);
        }
        return new Result("ERROR! resourceId为空",null);
    }

    @ApiOperation(value = "查询资源列表", notes = "使用管理员用户才能添加")
    @GetMapping("findResource")
    public Result findResource(String path,Boolean isUse,String roleIds){
        return resourceService.findResource(path,isUse,roleIds);
    }

}
