package com.mcylm.clay.securityservice.dao;

import com.mcylm.clay.securityservice.module.Uauth;

/**
 * Created by lenovo on 2017/8/7.
 */
public interface UauthDao {
    Uauth getUuidByUsernameAndPassword(String username);
}
