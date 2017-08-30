package com.mcylm.clay.service.openstackService.utils;

import com.google.gson.Gson;
import com.mcylm.clay.service.openstackService.model.ucenter.ParameterModel;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import redis.clients.jedis.JedisPoolConfig;

import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2017/8/10.
 */
public class RedisUtils {
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
        //将对象转成json字符串
        String uauthonJson = gson.toJson(uauthToken);
        stringValueOperations.set(token, uauthonJson, TIME, TimeUnit.MINUTES);
    }

    /**
     * 接受key value 并设置过期时间
     *
     * @param token
     * @param data
     */
    public static void setKey_Val_TimeOut(String token, String data) {
        //进键值对存入redis中，并设置过期时间30分钟
        stringValueOperations.set(token, data, TIME, TimeUnit.MINUTES);
    }

    /**
     * 根据key获取
     *
     * @param key
     * @return
     */
    public static String getValByKey(String key) {
        //根据key获取对应的值
        return stringValueOperations.get(key);
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
        //解析加密后的token
        String tokens = Base64Utils.decodeBase64String(token);
        //使用tokens获取对应的值
        String string = stringValueOperations.get(tokens);
        return string != null;
    }

    /**
     * 其他模块检验是否登录用
     *
     * @param parameterModel
     * @param fmlName
     * @return
     */
    public static String checkLogin(ParameterModel parameterModel, String fmlName) {
        //获取跳转的路径
        String redirectUrl = parameterModel.getRedirectUrl();
        //获取用户登录的token
        String token = parameterModel.getToken();
        //获取表单提交的formToken,防止表单重复提交
        String formToken = parameterModel.getFormToken();
        //用户登录信息
        String message = null;
        String redirectlogin = "";

        //根据用户的token判断redis中是否登录
        if (token != null && !"".equals(token)) {
            message = stringValueOperations.get(Base64Utils.decodeBase64String(token));
        }

        //如果没有登录，追加跳转路径及formtoken
        if (message == null || "".equals(message)) {
            StringBuffer redirectToLogin = new StringBuffer();
            redirectToLogin.append("redirect:http://localhost/security/author/login");

            //判断跳转路径是否为null，追加路径后面
            if (redirectUrl != null && !"".equals(redirectUrl)) {
                redirectToLogin.append("?redirectUrl=" + redirectUrl);
            }

            //追加表单提交的formtoken
            if (formToken != null && !"".equals(formToken)) {
                redirectToLogin.append("&formToken=" + formToken);
            }


            if (redirectToLogin.toString().contains("redirectUrl")) {
                redirectlogin = redirectToLogin.toString().replaceFirst("&", "?");
            }
            //返回跳转路径，并发第一个&替换为？
            return redirectlogin;
        }
        //返回目标页面的名字
        return fmlName;
    }

    /**
     * 根据 token 删除
     *
     * @param token
     */
    public static void deleteValByTocken(String token) {
        stringRedisTemplate.delete(token);
    }

}
