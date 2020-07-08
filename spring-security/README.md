# Spring Security
> 运行版本
- spring-boot-starter-security:2.2.5.RELEASE
---
> 密码加密方式

```
#默认的加密方式(会在密码前加上加密方式的ID)
PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
#固定的加密方式（不会再密码前加上加密方式的ID）
PasswordEncoder passwordEncoder = new BCryptPasswordEncoder()
PasswordEncoder passwordEncoder = new LdapShaPasswordEncoder()
PasswordEncoder passwordEncoder = new Md4PasswordEncoder()
PasswordEncoder passwordEncoder = NoOpPasswordEncoder.getInstance();
#.... (详情看PasswordEncoderFactories.createDelegatingPasswordEncoder方法)
```
---
