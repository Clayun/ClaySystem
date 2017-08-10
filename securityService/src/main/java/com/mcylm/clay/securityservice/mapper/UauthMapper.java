package com.mcylm.clay.securityservice.mapper;

import com.mcylm.clay.securityservice.module.Uauth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by lenovo on 2017/8/7.
 */
@Mapper
public interface UauthMapper {

    @Select("SELECT uuid,userName,passWord FROM pre_common_uauth WHERE  userName = #{username} OR phone = #{username}")
    Uauth getUuidByUsernameAndPassword(@Param(value = "username") String username);
}
