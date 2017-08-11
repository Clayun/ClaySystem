package com.mcylm.clay.securityservice.mapper;

import com.mcylm.clay.securityservice.module.UauthToken;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by lenovo on 2017/8/9.
 */
@Mapper
public interface UauthTokenMapper {

    @Insert("INSERT INTO pre_common_uauth_token(uuid,hostip,clientid,token,logintime) VALUES(#{uid},#{hostIp},#{sessionId},#{token},NOW())")
    Integer insertUauthTokenMessage(@Param(value = "uid") String uid, @Param(value = "hostIp") String hostIp, @Param(value = "sessionId") String sessionId, @Param(value = "token") String token);

    @Select("SELECT id,uuid,clientid,token,logintime,hostip FROM pre_common_uauth_token WHERE token = #{token}")
    UauthToken findUauthTokenByToken(@Param(value = "token") String token);

}
