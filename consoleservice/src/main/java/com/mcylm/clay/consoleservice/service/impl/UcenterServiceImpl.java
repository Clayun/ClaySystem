package com.mcylm.clay.consoleservice.service.impl;

import com.mcylm.clay.consoleservice.dao.UcenterDao;
import com.mcylm.clay.consoleservice.service.UcenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mr_Shen on 2017/8/7/007.
 */
@Service
public class UcenterServiceImpl implements UcenterService {

    @Autowired
    private UcenterDao ucenterDao;


}
