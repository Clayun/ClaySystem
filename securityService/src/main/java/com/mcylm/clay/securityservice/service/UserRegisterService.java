package com.mcylm.clay.securityservice.service;

import com.mcylm.clay.securityservice.module.Uauth;

/**
 * @Author:Wuyali
 * @Description:
 * @Date:Created in 15:10 2017/8/8
 * @Modified By:
 */
public interface UserRegisterService {


    Uauth findRegisterByUserName(String username);

    Uauth findRegisterByPhone(String phone);

    boolean insertResisterInfo(String userName,String phone,String email,String passWord);

    String insertResister(String userName, String phone, String email, String passWord);
}
