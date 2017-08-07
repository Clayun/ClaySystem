package com.mcylm.clay.service.normalservice.dao.Impl;

import com.google.gson.Gson;
import com.mcylm.clay.service.normalservice.dao.RedisDao;
import com.mcylm.clay.service.normalservice.dao.NormalDao;
import com.mcylm.clay.service.normalservice.mapper.NormalMapper;
import com.mcylm.clay.service.normalservice.model.Label;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mikesam on 2017/8/5.
 */
@Repository
public class NormalDaoImpl implements NormalDao {

    private Gson gson = new Gson();

    @Autowired
    private RedisDao redisDao;

    @Autowired
    private NormalMapper normalMapper;

    @Override
    public boolean initRedisCache() {

        List<Label> list = normalMapper.selectLabels();
        int num = 0;
        for(Label label : list){
            String bean = gson.toJson(label);
            redisDao.setKey(label.getKey(), bean);
            num++;
        }
        System.out.println("initRedisCacheCompleted!num:"+num);
        return true;
    }

    @Override
    public List<Label> selectLabelsByPage(String page) {
        return normalMapper.selectLabelsByPage(page);
    }
}
