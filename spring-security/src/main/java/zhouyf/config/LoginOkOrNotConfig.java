package zhouyf.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Zhouyf
 * @Data 2020-05-27  18:31
 * 配置登录成功后的响应或登录失败后的响应
 */
@Configuration
public class LoginOkOrNotConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
    }
}
