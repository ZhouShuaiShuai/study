package zhouyf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import zhouyf.service.RedisService;

/**
 * @author Zhouyf
 * @Data 2020-06-16  16:27
 */
@SpringBootApplication
public class RedisUtilApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(RedisUtilApplication.class, args);
        RedisService redisService = ctx.getBean(RedisService.class);
        redisService.run();
    }

}
