package com.mcylm.clay.service.normalservice.mapper;

import com.mcylm.clay.service.normalservice.model.Label;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Mikesam on 2017/8/5.
 */
@Mapper
public interface NormalMapper {

    @Select("select * from htm_common_labels")
    List<Label> selectLabels();

    @Select("select * from htm_common_labels l where l.`key` like #{page}")
    List<Label> selectLabelsByPage(String page);
}
