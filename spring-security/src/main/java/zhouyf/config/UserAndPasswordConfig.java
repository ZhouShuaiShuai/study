package zhouyf.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Zhouyf
 * @Data 2020-05-27  16:43
 * 通过代码配置用户名和密码>>通过配置文件配置用户名密码
 */
@Configuration
public class UserAndPasswordConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String a = passwordEncoder.encode("123456");
        //        System.out.println(a);
        //下面这两行配置表示在内存中配置了两个用户
        auth.inMemoryAuthentication()
                .withUser("zhouyf").roles("admin").password(a)
                .and()
                .withUser("admin").roles("user").password(a);
    }
}
