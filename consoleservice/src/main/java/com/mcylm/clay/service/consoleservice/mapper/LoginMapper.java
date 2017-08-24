package com.mcylm.clay.service.consoleservice.mapper;

import com.mcylm.clay.service.consoleservice.model.Login;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author:Mr_Shen
 * @Description: - -!
 * @Date:2017/8/24/024
 * @Modified By:None one
 */

@Mapper
public interface LoginMapper {

    @Select("select * from pre_console_login where username=#{username} and password=#{password}")
    Login tologin(Login login);

}