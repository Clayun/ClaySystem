package com.mcylm.clay.service.consoleservice.mapper;

import com.mcylm.clay.service.consoleservice.model.Ucenter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Mr_Shen on 2017/8/7/007.
 */
@Mapper
public interface UcenterMapper {

    @Select("select id,uuid,username,phone,createTime,permission,bindUser from console_common_ucenter")
    List<Ucenter> list();

    @Select("select id,uuid,username,phone,createTime,permission,bindUser from console_common_ucenter where id = #{id}")
    Ucenter toUpdateUcenter(Integer id);

}
