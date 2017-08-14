package com.mcylm.clay.service.consoleservice.dao.impl;

import com.mcylm.clay.service.consoleservice.dao.UauthDao;
import com.mcylm.clay.service.consoleservice.mapper.UauthMapper;
import com.mcylm.clay.service.consoleservice.model.Uauth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;
/**
 * Created by macbook on 2017/8/9.
 */
@Repository
public class UauthDaoImpl implements UauthDao{

    @Autowired
    private UauthMapper uauthMapper;


    @Override
    public List<Uauth> getlist(Map<String, Object> map) {
        List<Uauth> list = uauthMapper.getlist(map);
        return list;
    }

    @Override
    public void doUpdateUsername(String username, Integer id) {
        uauthMapper.doUpdateUsername(username,id);
    }

    @Override
    public void doUpdateUcenterPhone(String phone, Integer id) {
        uauthMapper.doUpdateUcenterPhone(phone,id);
    }

    @Override
    public void doUpdateEmail(String email, Integer id) {
        uauthMapper.doUpdateEmail(email,id);
    }

    @Override
    public void doUpdatePassword(String password, Integer id) {
        uauthMapper.doUpdatePassword(password,id);
    }

    @Override
    public void uauthadd(Uauth uauth) {
        uauthMapper.uauthadd(uauth);
    }

    @Override
    public void doUpdateContent(String content, Integer id) {
        uauthMapper.doUpdateContent(content,id);
    }

}
