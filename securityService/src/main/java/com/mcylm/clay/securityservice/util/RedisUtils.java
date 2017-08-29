package com.mcylm.clay.securityservice.util;

import com.google.gson.Gson;

import com.mcylm.clay.securityservice.module.ParameterModel;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import redis.clients.jedis.JedisPoolConfig;

import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2017/8/10.
 */
public class  RedisUtils {
    private static JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
    private static JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
    private static StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
    private static ValueOperations<String, String> stringValueOperations = null;
    private static Gson gson = new Gson();
    private final static Integer TIME = 30;

    static {
        //jedispoll 链接池的配置
        jedisPoolConfig.setMaxIdle(500);
        jedisPoolConfig.setMinIdle(0);
        jedisPoolConfig.setMaxWaitMillis(-1);

        //jedis工厂配置
        jedisConnectionFactory.setHostName("59.110.235.199");
        jedisConnectionFactory.setPort(6379);
        jedisConnectionFactory.afterPropertiesSet();
        jedisConnectionFactory.setPoolConfig(jedisPoolConfig);

        //设置属性
        stringRedisTemplate.setConnectionFactory(jedisConnectionFactory);
        stringRedisTemplate.afterPropertiesSet();
        stringValueOperations = stringRedisTemplate.opsForValue();
    }

    /**
     * 存入key value 并设置过期时间
     *
     * @param token
     * @param uauthToken
     */
    public static void setKey_Val_TimeOut(String token, Object uauthToken) {
        String uauthonJson = gson.toJson(uauthToken);
        stringValueOperations.set(token, uauthonJson, TIME, TimeUnit.MINUTES);
    }

    /**
     * 接受json 串key value 并设置过期时间
     *
     * @param token
     * @param data
     */
    public static void setKey_Val_TimeOut(String token, String data) {
        stringValueOperations.set(token, data, TIME, TimeUnit.MINUTES);
    }

    /**
     * 根据key获取
     *
     * @param key
     * @return
     */
    public static String getValByKey(String key) {
        String val = stringValueOperations.get(key);
        return val;
    }

    /**
     * 根据token 判断数据库是否存在
     * 并接入参数，返回路径
     * 登录模块用
     *
     * @param
     * @return
     */
    public static boolean checkTokenExit(String token) {
        String tokens = Base64Utils.decodeBase64String(token);
        String string = stringValueOperations.get(tokens);
        if (string != null)
            return true;
        return false;
    }

    /**
     * 其他模块检验是否登录用
     *
     * @param parameterModel
     * @param fmlName
     * @return
     */
    public static String checkLogin(ParameterModel parameterModel, String fmlName) {
        String redirectUrl = parameterModel.getRedirectUrl();
        String token = parameterModel.getToken();
        String message = null;
        if (token != null && !"".equals(token)) {
            message = stringValueOperations.get(Base64Utils.decodeBase64String(token));
        }
        if (message == null || "".equals(message)) {
            StringBuffer redirectToLogin = new StringBuffer();
            redirectToLogin.append("redirect:http://localhost/security/author/login");
            if (redirectUrl != null && !"".equals(redirectUrl)) {
                redirectToLogin.append("?redirectUrl=" + redirectUrl);
            }
            return redirectToLogin.toString();
        }
        return fmlName;
    }

    /**
     * 根据 token 删除
     *
     * @param token
     */
    public static void deleteValByTocken(String token) {
        stringRedisTemplate.delete(Base64Utils.decodeBase64String(token));
    }


}
