package zhouyf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zhouyf
 * @Data 2020-05-27  16:35
 */
@RestController
public class HelloController {

    @GetMapping(value = "/hello",produces = "application/json;charset=utf-8")
    public String hello() {
        return "hello！";
    }

}
