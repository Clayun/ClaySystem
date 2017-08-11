package com.mcylm.clay.securityservice.util;

import jdk.nashorn.internal.scripts.JD;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jca.cci.connection.ConnectionFactoryUtils;
import redis.clients.jedis.JedisPoolConfig;

import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2017/8/10.
 */
public class RedisUtils {
   /* private static StringRedisTemplate stringRedisTemplate = null;
    private static JedisPoolConfig jedisPoolConfig = null;
    private static JedisConnectionFactory jedisConnectionFactory = null;
    private static ValueOperations<String, String> stringStringValueOperations = null;
    static {
      stringRedisTemplate = new StringRedisTemplate();
       jedisPoolConfig = new JedisPoolConfig();
       jedisPoolConfig.setMaxIdle(300);
       jedisPoolConfig.setMaxWaitMillis(10000);
       jedisConnectionFactory = new JedisConnectionFactory();
       jedisConnectionFactory.setHostName("59.110.235.199");
       jedisConnectionFactory.setPort(6379);
       jedisConnectionFactory.setTimeout(2000);
       jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
       stringRedisTemplate.setConnectionFactory(jedisConnectionFactory);
       stringStringValueOperations = stringRedisTemplate.opsForValue();
       stringRedisTemplate.afterPropertiesSet();

//       ConnectionFactoryUtils
//       stringRedisTemplate.setConnectionFactory();
   }
  *//*  private static StringRedisTemplate redisTemplate = new StringRedisTemplate();


    private static ValueOperations<String, String> stringValueOperations = redisTemplate.opsForValue();
*//*


    *//**
     * 存入key value 并设置过期时间
     * @param key
     * @param value
     * @param timeout
     * @param unit
     *//*
    public static void setKey_Val_TimeOut(String key,String value,long timeout,TimeUnit unit){

        stringStringValueOperations.set(key,value,timeout,unit);
    };


    *//**
     * 根据 key
     * @param key
     * @return
     *//*
    public static String getValByKey(String key){

        String val = stringStringValueOperations.get(key);
        return val;
    }
*/


}
