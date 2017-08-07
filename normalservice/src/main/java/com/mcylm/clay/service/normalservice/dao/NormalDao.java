package com.mcylm.clay.service.normalservice.dao;

import com.mcylm.clay.service.normalservice.model.Label;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mikesam on 2017/8/5.
 */
public interface NormalDao {
    boolean initRedisCache();

    List<Label> selectLabelsByPage(String page);
}
