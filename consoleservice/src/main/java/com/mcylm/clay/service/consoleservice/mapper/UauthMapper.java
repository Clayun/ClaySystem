package com.mcylm.clay.service.consoleservice.mapper;

import com.mcylm.clay.service.consoleservice.model.Page;
import com.mcylm.clay.service.consoleservice.model.Uauth;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by macbook on 2017/8/9.
 */
@Mapper
public interface UauthMapper {

    @Update("update pre_common_uauth set username=#{username} where id = #{id}")
    void doUpdateUsername(@Param("username") String username, @Param("id") Integer id);

    @Update("update pre_common_uauth set phone=#{phone} where id = #{id}")
    void doUpdateUcenterPhone(@Param("phone")String phone, @Param("id")Integer id);

    @Update("update pre_common_uauth set email=#{email} where id = #{id}")
    void doUpdateEmail(@Param("email")String email, @Param("id")Integer id);

    @Update("update pre_common_uauth set password=#{password} where id = #{id}")
    void doUpdatePassword(@Param("password")String password, @Param("id")Integer id);

    @Update("update pre_common_uauth set content=#{content} where id = #{id}")
    void doUpdateContent(@Param("content")String content, @Param("id")Integer id);

    @Insert("insert into pre_common_uauth(uuid,userName,phone,email,passWord," +
            "createTime,content) values(#{uuid},#{username},#{phone},#{email}," +
            "#{password},#{createTime},#{content})")
    void uauthadd(Uauth uauth);

    @Select("select count(*) from pre_common_uauth")
    int getCount();

    @Select("select count(*) from pre_common_uauth where email like #{content}")
    int getEmailCount(String content);

    @Select("select count(*) from pre_common_uauth where userName like #{content}")
    int getUserNameCount(String content);

    @Select("select count(*) from pre_common_uauth where phone like #{content}")
    int getPhoneCount(String content);

    @Select("select * from pre_common_uauth order by id limit #{page.cPage},#{page.pageSize}")
    List<Uauth> getList(@Param("page")Page page, Map<String, Object> map);

    @Select("select * from pre_common_uauth where email like #{content} order by id")
    List<Uauth> getEmailList(@Param("content")String content);

    @Select("select * from pre_common_uauth where userName like #{content} order by id")
    List<Uauth> getUserNameList(@Param("content")String content);

    @Select("select * from pre_common_uauth where phone like #{content} order by id")
    List<Uauth> getPhoneList(@Param("content")String content);
}
