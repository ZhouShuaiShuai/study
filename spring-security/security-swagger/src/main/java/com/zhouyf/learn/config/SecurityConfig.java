package com.zhouyf.learn.config;

import com.zhouyf.learn.filter.RequestAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Zhouyf
 * @Data 2020-08-13  9:43
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)  //开启注解权限控制
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userService")
    private UserDetailsService userService;

    /**
     * 密码加密方式
     */
    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * 用户验证的方式
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
    }

    /**
     * 访问控制
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                //允许基于使用HttpServletRequest限制访问
                        authorizeRequests()

                // 设置不需要授权的请求
                .antMatchers("/login.html").permitAll()

                // 其它任何请求都需要验证权限
                .anyRequest().authenticated()

                // 设置自定义表单登录页面 设置默认登录成功跳转页面
                .and().formLogin()
//                .loginPage("/login.html")
                //成功登陆后默认跳转页面
                .defaultSuccessUrl("/swagger-ui.html")

                .and().sessionManagement() //session超时管理
                // 设置Session失效跳转页面
                .invalidSessionUrl("/login")
                // 设置最大Session数为1
                .maximumSessions(1)
                // 设置Session过期处理策略
                .expiredSessionStrategy(new SessionInformationExpiredStrategyImpl())
                .and()

                .and().formLogin()
                //登出的路径
                .and().logout().logoutUrl("/logout")
                .and().rememberMe()
                .and().httpBasic()

                .and()
                .cors()//跨域
                .and().csrf().disable()//禁用CSRF支持
                .addFilter(new RequestAuthorizationFilter(authenticationManager()));

    }

}
