//package zhouyf.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisClusterConfiguration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.RedisSentinelConfiguration;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.util.Assert;
//
///**
// * @author Zhouyf
// * @Data 2020-06-17  14:14
// */
//@Configuration
//public class RedisConnectionConfig {
//    /**
//     * Jedis
//     */
////    @Bean
////    public JedisConnectionFactory redisConnectionFactory() {
////        return new JedisConnectionFactory();
////    }
//
////    /**
////     * Lettuce
////     */
////    @Bean
////    public LettuceConnectionFactory redisConnectionFactory() {
////        return new LettuceConnectionFactory();
////    }
//
////    /**
////     * Jedis
////     */
////    @Bean
////    public RedisConnectionFactory jedisConnectionFactory() {
////        RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration()
////                .master("zhouyf")
////                .sentinel("10.172.246.227", 7001)
////                .sentinel("10.172.246.227", 7002)
////                .sentinel("10.172.246.227", 7003)
////                .sentinel("10.172.246.227", 7004)
////                .sentinel("10.172.246.227", 7005)
////                .sentinel("10.172.246.227", 7006);
////        return new JedisConnectionFactory(sentinelConfig);
////    }
//
////    /**
////     * Lettuce
////     */
////    @Bean
////    public RedisConnectionFactory lettuceConnectionFactory() {
////        RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration()
////                .master("zhouyf")
////                .sentinel("10.172.246.227", 7001)
////                .sentinel("10.172.246.227", 7002)
////                .sentinel("10.172.246.227", 7003)
////                .sentinel("10.172.246.227", 7004)
////                .sentinel("10.172.246.227", 7005)
////                .sentinel("10.172.246.227", 7006)
////                ;
////        return new LettuceConnectionFactory(sentinelConfig);
////    }
//}
