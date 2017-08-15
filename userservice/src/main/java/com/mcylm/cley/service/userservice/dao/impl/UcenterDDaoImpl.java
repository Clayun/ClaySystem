package com.mcylm.cley.service.userservice.dao.impl;

import com.mcylm.cley.service.userservice.dao.UcenterDDao;
import com.mcylm.cley.service.userservice.entity.UcenterD;
import com.mcylm.cley.service.userservice.mapper.UcenterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UcenterDDaoImpl implements UcenterDDao{

    @Autowired
    private UcenterMapper ucenterMapper;

    @Override
    public List<UcenterD> getUserList() {
        return ucenterMapper.getUserList();
    }

    @Override
    public UcenterD updateUser(UcenterD user) {
        return ucenterMapper.updateUser(user);
    }
}
