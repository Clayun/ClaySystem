package com.mcylm.clay.service.consoleservice.mapper;

import com.mcylm.clay.service.consoleservice.model.Uauth;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by macbook on 2017/8/9.
 */
@Mapper
public interface UauthMapper {

    @Select("select * from pre_common_uauth")
    List<Uauth> getlist(Map<String, Object> map);

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

}
