package com.mcylm.clay.service.consoleservice.service;

import com.mcylm.clay.service.consoleservice.model.Uauth;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by macbook on 2017/8/9.
 */
public interface UauthService {

    List<Uauth> getList(@Param("dropdownbox") String dropdownbox,@Param("content") String content,@Param("pageNo") Integer pageNo,@Param("pageSize") Integer pageSize, Map<String, Object> map);

    void doUpdateUsername(String username, Integer id);

    void doUpdateUcenterPhone(String phone, Integer id);

    void doUpdateEmail(String email, Integer id);

    void doUpdatePassword(String password, Integer id);

    void uauthadd(Uauth uauth);

    void doUpdateContent(String content, Integer id);

    int getCount(@Param("dropdownbox") String dropdownbox, @Param("content") String content);

}
