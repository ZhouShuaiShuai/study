# Spring Data Redis
> 运行版本
- spring-boot-starter-data-redis:2.2.5.RELEASE   
- *[官方文档](https://docs.spring.io/spring-data/redis/docs/2.2.5.RELEASE/reference/html/#)*
---
> 为了整合spring版本（也就是尽量使用spring提供的）选择使用 spring data redis   
> 此依赖jedis或Lettuce， 内部实现了对Lettuce和jedis两个客户端的封装，默认使用的是Lettuce  
>> 如果需要使用***jedis***作为redis客户端则需要在pom文件中排除`lettuce-core`依赖，并引入`jedis`
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
    <!-- 排除lettuce包，使用jedis代替-->
    <exclusions>
        <exclusion>
            <groupId>io.lettuce</groupId>
            <artifactId>lettuce-core</artifactId>
        </exclusion>
    </exclusions>
</dependency>
<!-- jedis -->
<dependency>
    <groupId>redis.clients</groupId>
    <artifactId>jedis</artifactId>
</dependency>
``` 
>> 如果需要使用***lettuce***作为redis客户端则需要在pom文件中手动引入`commons-pool2`依赖，因为jedis包中已经含有`commons-pool2`，所以jedis不用再手动引入
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-pool2</artifactId>
</dependency>
``` 
---


