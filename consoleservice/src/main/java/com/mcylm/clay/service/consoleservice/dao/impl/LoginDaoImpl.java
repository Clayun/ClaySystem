package com.mcylm.clay.service.consoleservice.dao.impl;

import com.mcylm.clay.service.consoleservice.dao.LoginDao;
import com.mcylm.clay.service.consoleservice.mapper.LoginMapper;
import com.mcylm.clay.service.consoleservice.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Mr_Shen
 * @Description: - -!
 * @Date:2017/8/24/024
 * @Modified By:None one
 */
@Repository
public class LoginDaoImpl implements LoginDao {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Login  tologin(Login login) {
        Login LoginMessage= loginMapper.tologin(login);
        return LoginMessage;
    }
}
