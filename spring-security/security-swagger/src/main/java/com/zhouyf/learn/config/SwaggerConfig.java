package com.zhouyf.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Administrator
 * @Data 2018-10-08  16:27
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket buildDocket() {

        //添加query参数start
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInf())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zhouyf.learn.controller"))//controller路径
                .paths(PathSelectors.any()).build();
        return docket;
    }



    private ApiInfo buildApiInf() {
        return new ApiInfoBuilder()
                .title("用户权限校验")
                .description("Spring Security + JWT 权限校验")
                .version("1.0v")
                .build();
    }

}
