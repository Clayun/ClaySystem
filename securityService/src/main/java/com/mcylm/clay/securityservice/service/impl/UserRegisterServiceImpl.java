package com.mcylm.clay.securityservice.service.impl;

import com.mcylm.clay.securityservice.dao.UserRegisterDao;
import com.mcylm.clay.securityservice.module.*;
import com.mcylm.clay.securityservice.service.UserRegisterService;
import com.mcylm.clay.securityservice.util.MD5Util;
import com.mcylm.clay.securityservice.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public Uauth findRegisterByUserName(String username) {

        return userRegisterDao.findRegisterByUserName(username);
    }

    @Override
    public Uauth findRegisterByPhone(String phone) {
        return userRegisterDao.findRegisterByPhone(phone);
    }

    @Override
    public boolean insertResisterInfo(String userName,String phone,String email,String passWord) {
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
        String birth = "1993-08-09";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        uDetails.setBirthday(date);
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
        }

        return flag;
    }

    @Override
    public String insertResister(String userName, String phone, String email, String passWord) {
        

        return null;
    }
}
