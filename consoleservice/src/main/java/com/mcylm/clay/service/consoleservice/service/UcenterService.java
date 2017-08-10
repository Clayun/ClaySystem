package com.mcylm.clay.service.consoleservice.service;

import com.mcylm.clay.service.consoleservice.model.Ucenter;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * Created by Mr_Shen on 2017/8/7/007.
 */
public interface UcenterService {

    List<Ucenter> getList(@Param("dropdownbox") String dropdownbox,@Param("content") String content,@Param("pageNo") Integer pageNo,@Param("pageSize") Integer pageSize, Map<String, Object> map);

    void ucenteradd(Ucenter ucenter);

    void ucenterdel(Integer id);

    void doUpdateUcenter(String username, Integer id);

    void doUpdateUcenterPhone(String phone, Integer id);

    void doUpdatePassword(String password, Integer id);

    int getCount(@Param("dropdownbox") String dropdownbox,@Param("content") String content);

}