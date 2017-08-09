package com.mcylm.clay.securityservice.dao.impl;

import com.mcylm.clay.securityservice.dao.UauthDao;
import com.mcylm.clay.securityservice.mapper.UauthMapper;
import com.mcylm.clay.securityservice.module.Uauth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2017/8/7.
 */
@Repository
public class UauthDaoImpl implements UauthDao {
    @Autowired
    private UauthMapper authMapper;

    @Override
    public List<Uauth> getUauths() {
        List<Uauth> result = authMapper.getUauths();
        return result;
    }
}
