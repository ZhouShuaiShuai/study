package zhouyf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

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
                .apis(RequestHandlerSelectors.basePackage("zhouyf.controller"))//controller路径
                .paths(PathSelectors.any()).build();
//                .securityContexts(securityContexts());
        return docket;
    }



    private ApiInfo buildApiInf() {
        return new ApiInfoBuilder()
                .title("数字配电网平台接口说明文档")
                .description("数字配电网平台")
                .version("1.0v")
                .build();
    }

}
