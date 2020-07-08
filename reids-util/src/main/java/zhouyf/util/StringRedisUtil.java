package zhouyf.util;

import ch.qos.logback.core.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * @author Zhouyf
 * @Data 2020-06-17  16:28
 */
@Component
public class StringRedisUtil {

    @Autowired
    StringRedisTemplate template;

    private static StringRedisTemplate stringRedisTemplate ;

    @PostConstruct
    private void init(){
        stringRedisTemplate = template;
    }

    public static void set(String key,String value){
        stringRedisTemplate.opsForValue().set(key,value);
    }

//    public static void set(String key,Long index,String value){
////        stringRedisTemplate.opsForList().leftPush(key,value);
//        stringRedisTemplate.expire(key,30000L, TimeUnit.SECONDS);
//        System.out.println(stringRedisTemplate.boundListOps(key).leftPop());
//    }

}
