package com.mcylm.clay.securityservice.dao.impl;

import com.google.gson.Gson;
import com.mcylm.clay.securityservice.dao.RedisDao;
import com.mcylm.clay.securityservice.module.UauthToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2017/8/10.
 */
@Repository
public class RedisDaoImpl implements RedisDao {
    private Gson gson = new Gson();

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void setKeyAndVal(String token, UauthToken uauthToken) {
        String uauthonJson = gson.toJson(uauthToken);
        ValueOperations<String, String> stringValueOperations = redisTemplate.opsForValue();
        stringValueOperations.set(token, uauthonJson, 30, TimeUnit.MINUTES);
    }

    @Override
    public String checkTokenExit(String token) {
        ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
        return stringStringValueOperations.get(token);
    }
}
