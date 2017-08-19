package com.mcylm.clay.securityservice.dao.impl;

import com.mcylm.clay.securityservice.dao.UserRegisterDao;
import com.mcylm.clay.securityservice.mapper.UserRegisterMapper;
import com.mcylm.clay.securityservice.module.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @Author:Wuyali
 * @Description:
 * @Date:Created in 15:56 2017/8/8
 * @Modified By:
 */
@Repository
public class UserRegisterDaoImpl implements UserRegisterDao{
 @Autowired
 private UserRegisterMapper userRegisterMapper;

 @Override
 public Uauth findRegisterByUserName(String username) {

     return userRegisterMapper.findUserByUserName(username);
 }

    @Override
    public Uauth findRegisterByPhone(String phone) {
        return userRegisterMapper.findRegisterByPhone(phone);
    }

    @Override
    public boolean insertAccountInfo(Account account) {
        return userRegisterMapper.insertAccountInfo(account);
    }

    @Override
    public boolean insertUcenterInfo(Ucenter ucenter) {
        return userRegisterMapper.insertUcenterInfo(ucenter);
    }

    @Override
    public boolean insertUcenterDetails(UcenterDetails ucenterDetails) {
        return userRegisterMapper.insertUcenterDetails(ucenterDetails);
    }

    @Override
    public boolean insertResisterInfo(Map<String, Object> map) {
        return userRegisterMapper.insertRegisterUser(map);
    }

}
