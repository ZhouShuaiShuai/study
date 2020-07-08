package com.zhouyf.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class TestViewApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(TestViewApplication.class,args);
        System.out.println("请访问 http://localhost 开始游戏！");
    }

    @GetMapping(value = "/",produces = "application/json;charset=utf-8")
    public String index(){
        return "/index.html";
    }
}
