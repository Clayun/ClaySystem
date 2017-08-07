package com.mcylm.clay.consoleservice.dao.impl;

import com.mcylm.clay.consoleservice.dao.UcenterDao;
import com.mcylm.clay.consoleservice.mapper.UcenterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Mr_Shen on 2017/8/7/007.
 */
@Repository
public class UcenterDaoImpl implements UcenterDao{

    @Autowired
    private UcenterMapper ucenterMapper;

}