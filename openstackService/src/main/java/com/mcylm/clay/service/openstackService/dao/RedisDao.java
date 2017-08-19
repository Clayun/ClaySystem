package com.mcylm.clay.service.openstackService.dao;

/**
 * Created by Mikesam on 2017/8/5.
 */
public interface RedisDao {

    void setKey(String key, String value);
    String getValue(String key);
}
