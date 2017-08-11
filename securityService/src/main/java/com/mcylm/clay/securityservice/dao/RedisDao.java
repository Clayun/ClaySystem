package com.mcylm.clay.securityservice.dao;

import com.mcylm.clay.securityservice.module.UauthToken;

/**
 * Created by lenovo on 2017/8/10.
 */
public interface RedisDao {
    void setKeyAndVal(String sessionId, UauthToken uauthToken);
}
