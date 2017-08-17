package com.mcylm.clay.securityservice.dao;

import com.mcylm.clay.securityservice.module.*;

import java.util.Map;

/**
 * @Author:Wuyali
 * @Description:
 * @Date:Created in 15:55 2017/8/8
 * @Modified By:
 */
public interface UserRegisterDao {


    Uauth findRegisterByUserName(String username);

    Uauth findRegisterByPhone(String phone);

    boolean insertAccountInfo(Account account);

    boolean insertUcenterInfo(Ucenter ucenter);

    boolean insertUcenterDetails(UcenterDetails ucenterDetails);

    boolean insertResisterInfo(Map<String, Object> map);
}
