package zhouyf.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import zhouyf.util.StringRedisUtil;

/**
 * @author Zhouyf
 * @Data 2020-06-16  16:49
 */
@Service
@Slf4j
public class RedisService {

    @Autowired
    StringRedisTemplate stringRedisTemplate ;

    public void run(){
        log.info("redis连接工厂：{}",stringRedisTemplate.getConnectionFactory());
        //添加key
//        stringRedisTemplate.opsForValue().set("user","Batman");
//        StringRedisUtil.set("user","Batman啊");
        stringRedisTemplate.opsForList().leftPush("user","Batman111");
        //获取key
//        log.info("从redis中获取key=user的值为：{}",stringRedisTemplate.opsForValue().get("user"));
//        log.info(stringRedisTemplate.opsForList().leftPop("user"));

        //删除key
//        stringRedisTemplate.delete("user");

    }


}
