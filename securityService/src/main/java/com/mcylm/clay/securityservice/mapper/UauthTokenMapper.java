package com.mcylm.clay.securityservice.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lenovo on 2017/8/9.
 */
@Mapper
public interface UauthTokenMapper {

    @Insert("INSERT INTO pre_common_uauth_token(uuid,hostip,clientid,token,logintime) VALUES(#{uid},#{hostIp},#{sessionId},#{token},NOW())")
    Integer insertUauthTokenMessage(@Param(value = "uid") String uid, @Param(value = "hostIp") String hostIp, @Param(value = "sessionId") String sessionId, @Param(value = "token") String token);
}
