package com.mcylm.clay.service.consoleservice.dao.impl;

import com.mcylm.clay.service.consoleservice.dao.UcenterDao;
import com.mcylm.clay.service.consoleservice.mapper.UcenterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Mr_Shen on 2017/8/7/007.
 */
@Repository
public class UcenterDaoImpl implements UcenterDao {

    @Autowired
    private UcenterMapper ucenterMapper;

}