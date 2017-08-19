package com.mcylm.clay.securityservice.service;

/**
 * @Author:Wuyali
 * @Description:
 * @Date:Created in 15:10 2017/8/8
 * @Modified By:
 */
public interface UserRegisterService {

    //验证用户名和手机号


    String  verifyRegisterUserInfo(String userName, String phone,String vpwd, String email, String passWord);
}
