package com.mcylm.clay.securityservice.service.impl;

import com.mcylm.clay.securityservice.dao.UserRegisterDao;
import com.mcylm.clay.securityservice.module.Account;
import com.mcylm.clay.securityservice.module.Uauth;
import com.mcylm.clay.securityservice.module.Ucenter;
import com.mcylm.clay.securityservice.module.UcenterDetails;
import com.mcylm.clay.securityservice.service.UserRegisterService;
import com.mcylm.clay.securityservice.util.MD5Util;
import com.mcylm.clay.securityservice.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Wuyali
 * @Description:
 * @Date:Created in 15:49 2017/8/8
 * @Modified By:
 */
@Service
public class UserRegisterServiceImpl implements UserRegisterService{
    @Autowired
    UserRegisterDao userRegisterDao;



    @Override
    public String  verifyRegisterUserInfo(String userName, String phone,String vpwd, String email, String passWord) {
        String str = null;
        Uauth uauth = userRegisterDao.findRegisterByUserName(userName);
       if (uauth != null ){
           str = "n1";
           return str;
       }
       Uauth uauth1 = userRegisterDao.findRegisterByPhone(phone);
       if(uauth1!= null){
           str="p2";
           return  str;
       }
        String uuid = StringUtils.getUuid();
        System.out.println(uuid);
        String pwd = MD5Util.generate(passWord);
        Map<String ,Object> map = new HashMap<String ,Object>();
        map.put("userName",userName);
        map.put("phone",phone);
        map.put("email",email);
        map.put("pwd",pwd);
        map.put("uuid",uuid);
        boolean flag = false;
        Account account = new Account();
        account.setUuid(uuid);
        account.setMoney("100000");
        account.setScore("0");
        account.setConsume("0");

        System.out.println("===");
        //户中心uuid,avatar,level,exp,content
        Ucenter ucenter = new Ucenter();
        ucenter.setUuid(uuid);
        ucenter.setAvatar("无");
        ucenter.setLevel("1000");
        ucenter.setExp("无");
        ucenter.setContent("优秀");


        UcenterDetails uDetails = new UcenterDetails();

        uDetails.setUuid(uuid);
        uDetails.setCn_Name("无");
        uDetails.setEn_Name("无");
        uDetails.setSex("男");
        uDetails.setJob("无");
        uDetails.setEducation("无");
        uDetails.setSchool("无");
        uDetails.setContent("无");
        uDetails.setLocationId("北京东城葫芦巷");


        flag = userRegisterDao.insertResisterInfo(map);

        if(flag){
            userRegisterDao.insertUcenterInfo(ucenter);


            userRegisterDao.insertUcenterDetails(uDetails);


            userRegisterDao.insertAccountInfo(account);
            str ="success";
            return str;
        }


        return str;
    }
}
