package com.mcylm.clay.service.normalservice.service.impl;

import com.google.gson.Gson;
import com.mcylm.clay.service.normalservice.dao.NormalDao;
import com.mcylm.clay.service.normalservice.dao.RedisDao;
import com.mcylm.clay.service.normalservice.model.Label;
import com.mcylm.clay.service.normalservice.service.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mikesam on 2017/8/5.
 */
@Service
public class InterfaceServiceImpl implements InterfaceService {

    @Autowired
    private RedisDao redisDao;

    @Autowired
    private NormalDao normalDao;

    @Override
    public Label selectLabelByKey(String key,List<Label> list) {
        for(Label label : list){
            if(label.equals(key)){
                return label;
            }
        }
        return null;
    }

    @Override
    public List<Label> selectLabelsByPage(String page) {
        return normalDao.selectLabelsByPage("%"+page+"%");
    }
}
