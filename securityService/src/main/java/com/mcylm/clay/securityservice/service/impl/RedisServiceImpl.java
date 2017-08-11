package com.mcylm.clay.securityservice.service.impl;

import com.mcylm.clay.securityservice.dao.RedisDao;
import com.mcylm.clay.securityservice.module.UauthToken;
import com.mcylm.clay.securityservice.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * redis业务层
 * Created by lenovo on 2017/8/10.
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisDao redisDao;

    /**
     * 把用户信息存入redis 并设置过期时间
     * @param token
     * @param uauthToken
     */
    @Override
    public void setKeyAndVal(String token, UauthToken uauthToken) {
        redisDao.setKeyAndVal(token, uauthToken);
    }

    /**
     * 判断是否在redis中有记录
     * @param token
     * @return
     */
    @Override
    public boolean checkTokenExit(String token) {
        String tokeJson = redisDao.checkTokenExit(token);
        if (tokeJson != null && !"".equals(tokeJson))
            return true;
        return false;
    }
}
