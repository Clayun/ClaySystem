package com.mcylm.clay.service.consoleservice.service.impl;

import com.mcylm.clay.service.consoleservice.dao.UcenterDao;
import com.mcylm.clay.service.consoleservice.model.Ucenter;
import com.mcylm.clay.service.consoleservice.service.UcenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Mr_Shen on 2017/8/7/007.
 */
@Service
public class UcenterServiceImpl implements UcenterService{

    @Autowired
    private UcenterDao ucenterDao;


    @Override
    public List<Ucenter> getList(Map<String, Object> map) {
        List<Ucenter> list=ucenterDao.getList(map);
        return list;
    }

    @Override
    public void ucenteradd(Ucenter ucenter) {
        ucenterDao.ucenteradd(ucenter);
    }

    @Override
    public void ucenterdel(Integer id) {
        ucenterDao.ucenterdel(id);
    }

    @Override
    public void doUpdateUcenter(String username, Integer id) {
        ucenterDao.doUpdateUcenter(username,id);
    }

    @Override
    public void doUpdateUcenterPhone(String phone, Integer id) {
        ucenterDao.doUpdateUcenterPhone(phone,id);
    }
}