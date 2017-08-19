package com.mcylm.clay.securityservice.mapper;

import com.mcylm.clay.securityservice.module.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * @Author:Wuyali
 * @Description:
 * @Date:Created in 15:58 2017/8/8
 * @Modified By:
 */
@Mapper
public interface UserRegisterMapper {

    @Select("SELECT uuid FROM pre_common_uauth WHERE  userName = #{username}")
    Uauth findUserByUserName(@Param(value = "username") String username);


    @Select("SELECT uuid FROM pre_common_uauth WHERE  phone = #{phone}")
    Uauth findRegisterByPhone(@Param(value = "phone") String phone);

    @Insert("insert into pre_common_uauth(uuid,userName,phone,email,passWord,createTime) values(#{uuid},#{userName},#{phone},#{email},#{pwd},now())")
    boolean insertRegisterUser(Map<String, Object> map);

    @Insert("insert into pre_common_account(uuid,money,score,consume) values(#{uuid},#{money},#{score},#{consume})")
    boolean insertAccountInfo(Account account);

    @Insert("insert into pre_common_ucenter_details(uuid,cn_Name,en_Name,sex,job,education,school,locationId,content) values(#{uuid},#{cn_Name},#{en_Name},#{sex},#{job},#{education},#{school},#{locationId},#{content}) ")
    boolean insertUcenterDetails(UcenterDetails ucenterDetails);

    @Insert("insert into pre_common_ucenter(uuid,avatar,level,exp,content) values(#{uuid},#{avatar},#{level},#{exp},#{content})")
    boolean insertUcenterInfo(Ucenter ucenter);
}
