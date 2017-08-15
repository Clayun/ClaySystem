package com.mcylm.cley.service.userservice.service.impl;

import com.mcylm.cley.service.userservice.dao.UcenterDDao;
import com.mcylm.cley.service.userservice.entity.UcenterD;
import com.mcylm.cley.service.userservice.mapper.UcenterMapper;
import com.mcylm.cley.service.userservice.service.UCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UcenterServiceImpl implements UCenterService {

    @Autowired
    private UcenterDDao ucenterDDao;

    @Override
    public List<UcenterD> getUserList() {
        return ucenterDDao.getUserList();
    }

    @Override
    public UcenterD updateUser(UcenterD user) {
        return ucenterDDao.updateUser(user);
    }
}
