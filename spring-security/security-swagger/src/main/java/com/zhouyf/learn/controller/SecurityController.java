package com.zhouyf.learn.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author Zhouyf
 * @Data 2020-08-17  9:37
 */
@RestController
@Api(tags = {"系统操作相关接口"})
public class SecurityController {

}
