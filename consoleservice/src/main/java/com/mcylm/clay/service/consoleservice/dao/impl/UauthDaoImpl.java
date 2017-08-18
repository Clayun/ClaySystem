package com.mcylm.clay.service.consoleservice.dao.impl;

import com.mcylm.clay.service.consoleservice.dao.UauthDao;
import com.mcylm.clay.service.consoleservice.mapper.UauthMapper;
import com.mcylm.clay.service.consoleservice.model.Page;
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
    public List<Uauth> getList(Page page, Map<String, Object> map) {
        List<Uauth> list=uauthMapper.getList(page,map);
        return list;
    }

    @Override
    public List<Uauth> getEmailList(String content) {
        List<Uauth> list=uauthMapper.getEmailList(content);
        return list;
    }

    @Override
    public List<Uauth> getUserNameList(String content) {
        List<Uauth> list=uauthMapper.getUserNameList(content);
        return list;
    }

    @Override
    public List<Uauth> getPhoneList(String content) {
        List<Uauth> list=uauthMapper.getPhoneList(content);
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

    @Override
    public int getCount() {
        int listCount=uauthMapper.getCount();
        return listCount;
    }

    @Override
    public int getEmailCount(String content) {
        int listCount=uauthMapper.getEmailCount(content);
        return listCount;
    }

    @Override
    public int getUsernameCount(String content) {
        int listCount=uauthMapper.getUserNameCount(content);
        return listCount;
    }

    @Override
    public int getPhoneCount(String content) {
        int listCount=uauthMapper.getPhoneCount(content);
        return listCount;
    }

}
