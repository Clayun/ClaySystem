package com.mcylm.clay.securityservice.mapper;

import com.mcylm.clay.securityservice.module.ParameterModel;
import com.mcylm.clay.securityservice.module.Uauth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by lenovo on 2017/8/7.
 */
@Mapper
public interface UauthMapper {

    @Select("SELECT uuid,userName,passWord FROM pre_common_uauth WHERE  userName = #{username} OR phone = #{username}")
    Uauth getUuidByUsernameAndPassword(@Param(value = "username") String username);

    @Select("SELECT uuid,phone,email FROM pre_common_uauth WHERE userName = #{username} OR phone = #{username}")
    Uauth checkName(ParameterModel parameterModel);

    @Update("UPDATE pre_common_uauth SET passWord = #{password} WHERE phone = #{phone}")
    void updatePassword(@Param(value = "password") String password, @Param(value = "phone") String phone);

    @Select("SELECT uuid,userName FROM pre_common_uauth WHERE uuid = #{uuid}")
    Uauth getUauthByUuid(@Param(value = "uuid") String uuid);
}
