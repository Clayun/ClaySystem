package com.mcylm.clay.service.consoleservice.dao.impl;

import com.mcylm.clay.service.consoleservice.dao.UcenterDao;
import com.mcylm.clay.service.consoleservice.mapper.UcenterMapper;
import com.mcylm.clay.service.consoleservice.model.Page;
import com.mcylm.clay.service.consoleservice.model.Ucenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Mr_Shen on 2017/8/7/007.
 */
@Repository
public class UcenterDaoImpl implements UcenterDao {

    @Autowired
    private UcenterMapper ucenterMapper;

    @Override
    public List<Ucenter> getList(Page page,Map<String, Object> map) {
        List<Ucenter> list=ucenterMapper.getList(page,map);
        return list;
    }

    @Override
    public List<Ucenter> getIDList(String content) {
        List<Ucenter> list=ucenterMapper.getIDList(content);
        return list;
    }

    @Override
    public List<Ucenter> getUsernameList(String content) {
        List<Ucenter> list=ucenterMapper.getUsernameList(content);
        return list;
    }

    @Override
    public List<Ucenter> getPhoneList(String content) {
        List<Ucenter> list=ucenterMapper.getPhoneList(content);
        return list;
    }

    @Override
    public void ucenteradd(Ucenter ucenter) {
        ucenterMapper.ucenteradd(ucenter);
    }

    @Override
    public void ucenterdel(Integer id) { ucenterMapper.ucenterdel(id); }

    @Override
    public void doUpdateUcenter(String username, Integer id) {
        ucenterMapper.doUpdateUcenter(username,id);
    }

    @Override
    public void doUpdateUcenterPhone(String phone, Integer id) {
        ucenterMapper.doUpdateUcenterPhone(phone,id);
    }

    @Override
    public void doUpdatePassword(String password, Integer id) { ucenterMapper.doUpdatePassword(password,id);}

    @Override
    public int getCount() {
        int listCount=ucenterMapper.getCount();
        return listCount;
    }

    @Override
    public int getIDCount(String content) {
        int listcount=ucenterMapper.getIDCount(content);
        return listcount;
    }

    @Override
    public int getUsernameCount(String content) {
        int listcount=ucenterMapper.getUsernameCount(content);
        return listcount;
    }

    @Override
    public int getPhoneCount(String content) {
        int listcount=ucenterMapper.getPhoneCount(content);
        return listcount;
    }

}