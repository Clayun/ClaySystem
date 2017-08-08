package com.mcylm.clay.service.consoleservice.dao.impl;

import com.mcylm.clay.service.consoleservice.dao.UcenterDao;
import com.mcylm.clay.service.consoleservice.mapper.UcenterMapper;
import com.mcylm.clay.service.consoleservice.model.Ucenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mr_Shen on 2017/8/7/007.
 */
@Repository
public class UcenterDaoImpl implements UcenterDao{

    @Autowired
    private UcenterMapper ucenterMapper;

    @Override
    public List<Ucenter> ucenterlist() {
        return ucenterMapper.list();
    }

   /* @Override
    public Ucenter toUpdateUcenter(Integer id) {
        return ucenterMapper.toUpdateUcenter(id);
    }*/

    @Override
    public void doUpdateUcenter(String username, Integer id) {
        ucenterMapper.doUpdateUcenter(username,id);
    }
}