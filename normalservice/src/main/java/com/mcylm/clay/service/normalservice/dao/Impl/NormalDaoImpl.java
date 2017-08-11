package com.mcylm.clay.service.normalservice.dao.Impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mcylm.clay.service.normalservice.dao.RedisDao;
import com.mcylm.clay.service.normalservice.dao.NormalDao;
import com.mcylm.clay.service.normalservice.mapper.NormalMapper;
import com.mcylm.clay.service.normalservice.model.Label;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mikesam on 2017/8/5.
 * Dao层实现类
 */
@Repository
public class NormalDaoImpl implements NormalDao {

    private Gson gson = new Gson();

    @Autowired
    private RedisDao redisDao;

    @Autowired
    private NormalMapper normalMapper;

    /**
     * 初始化redis缓存，存储页面标签缓存
     * @return
     */
    @Override
    public boolean initRedisCache() {
        redisDao.setKey("normalcache","");
        List<Label> list = normalMapper.selectLabels();
        redisDao.setKey("normalcache",gson.toJson(list));
        return true;
    }

    /**
     * 从redis缓存里模糊查询，返回list
     * @param page
     * @return
     */
    @Override
    public List<Label> selectLabelsByPage(String page) {
        if(gson.fromJson(redisDao.getValue("normalcache"), new TypeToken<List<Label>>(){}.getType()) == null){
            initRedisCache();
        }
        List<Label> list = gson.fromJson(redisDao.getValue("normalcache"), new TypeToken<List<Label>>(){}.getType());

        List list1 = new ArrayList();
        for (Label label : list){
            if(label.getKey().contains(page)){
                list1.add(label);
            }
        }
        return list1;
    }
}
